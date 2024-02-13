import javax.swing.*;

public class Update{
    JFrame frame;
    JLabel idLabel, firstNameLabel, lastNameLabel, addressLabel, genderLabel;
    JTextField idField, firstNameField, lastNameField, addressField;
    JRadioButton maleRadioButton, femaleRadioButton;
    ButtonGroup genderGroup;
    JButton addMenuItem, AddDegreeMenuItem, updateUser, showMenuItem;

    public Update() {
        // Set the frame properties
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu dataMenu = new JMenu("Data");

        // Create menu items (JMenuItems) for the buttons without setting action listeners
        addMenuItem = new JButton("Add");
        AddDegreeMenuItem = new JButton("Add Degree");
        updateUser = new JButton("Update User");
        showMenuItem = new JButton("Show");

        // Add menu items to the menu
        dataMenu.add(addMenuItem);
        dataMenu.add(AddDegreeMenuItem);
        dataMenu.add(updateUser);
        dataMenu.add(showMenuItem);

        // Add the menu to the menu bar
        menuBar.add(dataMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Set layout to null to allow absolute positioning
        frame.setLayout(null);

        // Create and add components
        idLabel = new JLabel("ID :");
        idLabel.setBounds(100, 55, 130, 25);
        frame.add(idLabel);

        idField = new JTextField();
        idField.setBounds(190, 55, 150, 25);
        frame.add(idField);

        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(100, 100, 130, 25);
        frame.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(190, 100, 150, 25);
        frame.add(firstNameField);

        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(100, 145, 130, 25);
        frame.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(190, 145, 150, 25);
        frame.add(lastNameField);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(100, 190, 130, 25);
        frame.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(190, 190, 150, 25);
        frame.add(addressField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100, 235, 150, 25);
        frame.add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(190, 235, 80, 25);
        frame.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(270, 235, 80, 25);
        frame.add(femaleRadioButton);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Make the frame visible
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        Update updateUser1 = new Update();
    }
}