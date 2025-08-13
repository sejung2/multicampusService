import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Dotenv dotenv = Dotenv.configure()
            .directory(".")
            .load();

    public static void main(String[] args) {
        String url = dotenv.get("DB_URL");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL");

            if (rs.next()) {
                System.out.println("Current date is " + rs.getTimestamp(1));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}