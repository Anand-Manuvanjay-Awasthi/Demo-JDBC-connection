import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServerConnection {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:3306;"
                + "databaseName=learning_db;"
                + "user=root@localhost;"
                + "password=J1a2y3a4;";

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl);

            // Create and execute a basic SQL query
            String SQL = "SELECT * FROM employee";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the result set and print the data
            while (rs.next()) {
                System.out.println(rs.getString("CustomerID") + " - " + rs.getString("CustomerName"));
            }

            // Close the resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Usually throws SQL exception and I/O exception so u can use throw keyword as well instead of try catch//
    }
}
