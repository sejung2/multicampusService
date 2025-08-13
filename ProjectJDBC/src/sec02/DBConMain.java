package sec02;

import java.sql.Connection;

public class DBConMain {
    public static void main(String[] args) {
        Connection con = null;
        DBConnect dbCon = new DBConnect();
        con = dbCon.getConnection();
    }
}
