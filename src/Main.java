import java.sql.*;

public class Main {

    static String db_host = "jdbc:mysql://localhost/test";
    static String db_username = "root";
    static String db_password = "";
    static Connection conn;
    public static void main(String[] args) throws SQLException {

//        Login login = new Login();

//      Register r = new Register();

        DB_Connect dbConnect = new DB_Connect();
        ResultSet resultSet = dbConnect.selectData("students", "is");

            while (resultSet.next()) {
                // Retrieve data for each column
                String column1 = resultSet.getString(1);
                String column2 = resultSet.getString(2);
                // ... (retrieve other columns as needed)

                // Print the data to the screen
                System.out.println("Column 1: " + column1);
                System.out.println("Column 2: " + column2);
                // ... (print other columns as needed)
            }

















//        try {
//            conn= DriverManager.getConnection(db_host,db_username,db_password);
//
//            // Create a Statement
//            Statement statement = conn.createStatement();

            // Create a simple users table
//            String query = "CREATE TABLE IF NOT EXISTS username1 ("
//                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
//                    + "username VARCHAR(50) NOT NULL,"
//                    + "password VARCHAR(50) NOT NULL)";

            // Create a simple student table
//            String query = "CREATE TABLE IF NOT EXISTS students (" +
//                    "    id INT AUTO_INCREMENT PRIMARY KEY," +
//                    "    first_name VARCHAR(50) NOT NULL," +
//                    "    last_name VARCHAR(50) NOT NULL," +
//                    "    address VARCHAR(255)," +
//                    "    department VARCHAR(50)," +
//                    "    gender VARCHAR(10)" +
//                    ");";

            // Execute the query
//            statement.execute(query);
//
//            System.out.println("Table 'users' created successfully.");

//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }
}