import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddDegree {
    JFrame frame;
    JTable table;
    JSplitPane splitPane;
    JPanel rightPanel;
    JLabel JavaLabel, ComputerGraphicsLabel, CLabel, ComputerArchitectureLabel, MicroProcessorLabel, DataCommunicationLabel;
    JTextField JavaTextField, ComputerGraphicsTextField, CTextField, ComputerArchitectureTextField, MicroProcessorTextField, DataCommunicationTextField;
    JButton sendDegreeButton;
    JMenuBar menuBar;
    JMenu dataMenu;
    JButton addButton , addDegreeButton ,updateUserButton ,showButton;

    public AddDegree() {
        // Set the frame properties
        frame = new JFrame("Add Degree");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout to BorderLayout
        frame.setLayout(new BorderLayout());

        // Create and add components
        createMenu();
        createTable();
        createRightPanel();

        // Create a split pane with the table on the left and additional components on the right
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(table), rightPanel);
        splitPane.setDividerLocation(0.5); // Set the initial divider location as a ratio

        // Add the split pane to the frame
        frame.add(splitPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void createMenu() {
        menuBar = new JMenuBar();

        dataMenu = new JMenu("Data");

        addButton = new JButton("ADD");
        addDegreeButton = new JButton("Add Degree ");
        updateUserButton = new JButton("Update User");
        showButton =new JButton("Show");

        dataMenu.add(addButton);
        dataMenu.add(addDegreeButton);
        dataMenu.add(updateUserButton);
        dataMenu.add(showButton);

        menuBar.add(dataMenu);

        frame.setJMenuBar(menuBar);
    }

    private void createTable() {
        // Sample data for the table
        Object[][] data = {
                {1, "John", "Doe"},
                {2, "Jane", "Smith"},
                // Add more data as needed
        };

        // Column names for the table
        String[] columnNames = {"ID", "First Name", "Last Name"};

        // Create a custom DefaultTableModel
        NonEditableTableModel model = new NonEditableTableModel(data, columnNames);

        // Create a JTable with the model
        table = new JTable(model);

        // Set the table properties
        table.setFillsViewportHeight(true);
    }

    private void createRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(12, 2));

        // Additional components for entering grades
        JavaLabel = new JLabel("  Java:");
        JavaTextField = new JTextField();
        ComputerGraphicsLabel = new JLabel("  Computer Graphics :");
        ComputerGraphicsTextField = new JTextField();
        CLabel = new JLabel("  C :");
        CTextField = new JTextField();
        ComputerArchitectureLabel = new JLabel("   Architecture :");
        ComputerArchitectureTextField = new JTextField();
        MicroProcessorLabel = new JLabel("  Microprocessor :");
        MicroProcessorTextField = new JTextField();
        DataCommunicationLabel = new JLabel("  Data Communication :");
        DataCommunicationTextField = new JTextField();

        sendDegreeButton = new JButton("Send Degree");

        // Add components to the right panel
        rightPanel.add(JavaLabel);
        rightPanel.add(JavaTextField);
        rightPanel.add(ComputerGraphicsLabel);
        rightPanel.add(ComputerGraphicsTextField);
        rightPanel.add(CLabel);
        rightPanel.add(CTextField);
        rightPanel.add(ComputerArchitectureLabel);
        rightPanel.add(ComputerArchitectureTextField);
        rightPanel.add(MicroProcessorLabel);
        rightPanel.add(MicroProcessorTextField);
        rightPanel.add(DataCommunicationLabel);
        rightPanel.add(DataCommunicationTextField);
        rightPanel.add(sendDegreeButton);
    }

    // Custom DefaultTableModel to make specific columns non-editable
    private class NonEditableTableModel extends DefaultTableModel {
        NonEditableTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Make specific columns non-editable (e.g., ID, First Name, and Last Name)
            return !(column == 0 || column == 1 || column == 2);
        }
    }

    public static void main(String[] args) {
        AddDegree addDegree = new AddDegree();
    }
}