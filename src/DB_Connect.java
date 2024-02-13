import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Connect {

    private static final String DB_HOST = "jdbc:mysql://localhost/test";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;

    public DB_Connect() {
        try {
            // Load the JDBC driver
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean addUser(String username, String password) {
        try {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Add other methods for updating, deleting, saving data as needed

    public boolean valueExists(String value, String tableName, String columnName) {
        try {
            String sql = "SELECT COUNT(*) FROM " + tableName + " WHERE " + columnName + " = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, value);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public int checkUserInfo(String username, String password) {
        try {
            String sql = "SELECT username, password FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Username exists, now check if the provided password matches
                        String storedPassword = resultSet.getString("password");

                        // Validate password
                        if (storedPassword.equals(password)) {
                            // Password is correct
                            return 1;
                        } else {
                            // Incorrect password
                            return 0;
                        }
                    } else {
                        // Username does not exist
                        return -1;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public boolean addStudent(String firstname, String lastname, String address, String department, String gender) {
        try {
            String sql = "INSERT INTO students (first_name, last_name, address, department, gender) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, firstname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, address);
                preparedStatement.setString(4, department);
                preparedStatement.setString(5, gender);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet selectData(String tableName, String department) {
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE department = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, department);

                // Execute the query and return the result set
                return preparedStatement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
