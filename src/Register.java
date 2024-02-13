import javax.swing.*;
import java.awt.*;

public class Register {
    JFrame frame;
    JLabel usernameLabel, passwordLabel, confirmPasswordLabel, departmentLabel;
    JButton registerButton, backButton;
    JTextField usernameField;
    JComboBox<String> departmentComboBox;
    JPasswordField passwordField, confirmPasswordField;

    public Register() {
        // Set the frame properties
        frame = new JFrame("Register");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Dell\\IdeaProjects\\untitled\\src\\WhatsApp Image 2023-12-21 at 23.58.29_b61c18d6.jpg");
        Image img = backgroundImage.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(img);

        // Set the background image as the content pane
        frame.setContentPane(new JLabel(backgroundImage));

        // Set layout to null to allow absolute positioning
        frame.setLayout(null);

        // Create and add components
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100, 150, 130, 25);
        frame.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(220, 152, 150, 25);
        frame.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 195, 130, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 197, 150, 25);
        frame.add(passwordField);

        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(100, 240, 150, 25);
        frame.add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(220, 242, 150, 25);
        frame.add(confirmPasswordField);

        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(100, 285, 150, 25);
        frame.add(departmentLabel);

        // Add departments to the combobox
        String[] departments = {"IT", "Mechatronics", "Autotronics", "Energy", "Artificial limbs"};
        departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.setBounds(220, 287, 150, 25);
        frame.add(departmentComboBox);

        backButton = new JButton("Login");
        backButton.setBounds(250, 330, 90, 25);
        frame.add(backButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(100, 330, 90, 25);
        frame.add(registerButton);

        // Make the frame visible
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {

        Register register = new Register();
  }
}