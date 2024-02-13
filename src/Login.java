import javax.swing.*;
import java.awt.*;

public class Login {
    JFrame frame;
    JLabel usernameLabel, passwordLabel;
    JButton loginButton, registerButton;
    JTextField usernameField;
    JPasswordField passwordField;

    public Login() {
        // Set the frame properties
        frame = new JFrame("Login");
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
        usernameField.setBounds(190, 152, 150, 25);
        frame.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 195, 130, 25);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 197, 150, 25);
        frame.add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(250, 250, 90, 25);
        frame.add(registerButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 250, 90, 25);
        frame.add(loginButton);

        // Make the frame visible
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}