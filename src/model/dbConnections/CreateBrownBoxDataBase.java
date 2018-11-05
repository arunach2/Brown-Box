package model.dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateBrownBoxDataBase implements ICreateDataBase {
    public Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/BrownBox?useSSL=false";
        String user = "root";
        String password = "";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, password);

        }

        catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}
