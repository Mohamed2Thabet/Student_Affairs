import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Show {
    private JFrame frame;
    private JTable table;
    private JButton printButton, addNewStudentButton, updateButton, addMenuItem, addDegreeMenuItem, updateUserMenuItem, showMenuItem, northButton, southButton, eastButton, westButton;
    private JMenuBar menuBar;
    private JMenu dataMenu;
    private JPanel buttonPanel, updateButtonPanel;

    public Show() {
        frame = new JFrame("Show Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a menu bar
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.gray);

        // Create a menu
        dataMenu = new JMenu("Data");
        dataMenu.setForeground(Color.white);

        // Create menu items for the buttons without setting action listeners
        addMenuItem = new JButton("Add");
        addDegreeMenuItem = new JButton("Add Degree");
        updateUserMenuItem = new JButton("Update Student");
        showMenuItem = new JButton("Show");

        // Add menu items to the menu
        dataMenu.add(addMenuItem);
        dataMenu.add(addDegreeMenuItem);
        dataMenu.add(updateUserMenuItem);
        dataMenu.add(showMenuItem);

        // Add the menu to the menu bar
        menuBar.add(dataMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        DB_Connect dbConnect = new DB_Connect();
        ResultSet resultSet = dbConnect.selectData("students","is");


        // Sample data
        Object[][] data = {
                {"John", "Doe", 90, 91, 92, 93, 94, 95},
                {"Jane", "Smith", 78, 92, 80, 85, 88, 90},
                // Add more data as needed
        };

        // Column names
        String[] columnNames = {"First Name", "Last Name", "Java", "Computer Graphics", "C", "Architecture", "Microprocessor", "Data Communication", "Total"};

        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        table = new JTable(model);

        // Set the table properties
        table.setFillsViewportHeight(true);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame's content pane
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create buttons for each side
        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");

        // Create a panel for the buttons
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updateButtonPanel = new JPanel(); // Initialize updateButtonPanel

        // Set layout for updateButtonPanel
        updateButtonPanel.setLayout(null);

        // Create the Print button
        printButton = new JButton("Print");
        addNewStudentButton = new JButton("Add New Student");

        // Add buttons to the panel
        buttonPanel.add(addNewStudentButton);
        buttonPanel.add(printButton);

        // Add the Update button to the right side
        updateButton = new JButton("Update");
        updateButton.setBounds(0, 0, 80, 30);
        updateButtonPanel.add(updateButton);

        // Add buttons to the frame's content pane
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(updateButtonPanel, BorderLayout.EAST);

//        frame.getContentPane().add(northButton, BorderLayout.NORTH);
//        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
//        frame.getContentPane().add(updateButtonPanel, BorderLayout.EAST);
//        frame.getContentPane().add(westButton, BorderLayout.WEST);

        // Set frame properties
        frame.setSize(800, 400);
        frame.setVisible(true);

        // Set action listeners for menu items
        showMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the "Show" menu item action
                JOptionPane.showMessageDialog(frame, "You clicked Show menu item!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Show::new);
    }
}
