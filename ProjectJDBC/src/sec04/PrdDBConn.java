package sec04;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrdDBConn {
    private final Dotenv dotenv = Dotenv.configure()
            .directory(".")
            .load();

    public Connection getConnection() {
        Connection con = null;

        try {
            String url = dotenv.get("DB_URL");
            String username = dotenv.get("DB_USERNAME");
            String password = dotenv.get("DB_PASSWORD");

            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("DB 연결성공!");
            } else {
                System.out.println("DB 연결실패!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
