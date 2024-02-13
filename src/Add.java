import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class Add {
    JFrame frame;
    JLabel firstNameLabel, lastNameLabel, addressLabel, genderLabel, departmentLabel;
    JTextField firstNameField, lastNameField, addressField;
    JComboBox<String> departmentComboBox;
    JRadioButton maleRadioButton, femaleRadioButton;
    ButtonGroup genderGroup;
    JButton addButton;

    public Add() {
        // Set the frame properties
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu dataMenu = new JMenu("Data");

        // Create menu items (JMenuItems) for the buttons without setting action listeners
        addButton = new JButton("Add");

        // Add menu items to the menu
        dataMenu.add(addButton);

        // Add the menu to the menu bar
        menuBar.add(dataMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Set layout to null to allow absolute positioning
        frame.setLayout(null);

        // Create and add components
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(100, 100, 130, 25);
        frame.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(190, 102, 150, 25);
        frame.add(firstNameField);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(100, 145, 130, 25);
        frame.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(190, 147, 150, 25);
        frame.add(lastNameField);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(100, 190, 130, 25);
        frame.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(190, 192, 150, 25);
        frame.add(addressField);

        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(100, 235, 150, 25);
        frame.add(departmentLabel);

        // Create a dropdown list for the department
        String[] departmentOptions = {"", "is", "os", "ai"};
        departmentComboBox = new JComboBox<>(departmentOptions);
        departmentComboBox.setBounds(190, 237, 150, 25);
        frame.add(departmentComboBox);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100, 280, 150, 25);
        frame.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(190, 282, 80, 25);
        frame.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(270, 282, 80, 25);
        frame.add(femaleRadioButton);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        addButton.setBounds(200, 330, 80, 25);
        frame.add(addButton);

        // Add ActionListener to addButton
        addButton.addActionListener(new addButtonListener());

        // Make the frame visible
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private class addButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            firstName = firstName.trim();
            lastName = lastName.trim();
            address = address.trim();
            String selectedDepartment = (String) departmentComboBox.getSelectedItem();

            // Get the selected gender
            String selectedGender = "";

            if(maleRadioButton.isSelected()) {selectedGender = "Male";}
            else if (femaleRadioButton.isSelected()) {selectedGender = "Female";}


            // Iterate through the radio buttons to find the selected one
//            String selectedGender = getSelectedRadioButtonText(genderGroup);


            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "First Name is Required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Last Name is Required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Address is Required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedDepartment.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Department is Required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedGender.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Gender Name is Required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DB_Connect dbConnect = new DB_Connect();
            boolean success =  dbConnect.addStudent(firstName,lastName,address,selectedDepartment,selectedGender);

            if (success) {
                JOptionPane.showMessageDialog(frame, "Student added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                firstNameField.setText("");
                lastNameField.setText("");
                addressField.setText("");
                departmentComboBox.setSelectedItem("");
                genderGroup.clearSelection();

            } else {
                JOptionPane.showMessageDialog(frame, "Failed to add student", "Error", JOptionPane.ERROR_MESSAGE);
            }
            dbConnect.closeConnection();
        }
    }
                    // Method to get the text of the selected radio button in a ButtonGroup
//                    private String getSelectedRadioButtonText(ButtonGroup group) {
//                        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements(); ) {
//                            AbstractButton button = buttons.nextElement();
//                            if (button.isSelected()) {
//                                return button.getText();
//                            }
//                        }
//                        return "";
//                    }



        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new Add());
        }
    }
