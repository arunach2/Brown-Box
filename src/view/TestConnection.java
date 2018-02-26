package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class TestConnection {
	public static void main(String[] Args) {
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		
		String user = "root";
	 
	    String password = "Hog123er";
	    
	    try {
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM MEMBER";
            
            Statement st = (Statement) con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) { 
            	 int id = rs.getInt("MemberID"); 
            	 String str1 = rs.getString("FirstName");
            	 String str2 = rs.getString("LastName");
            	 String str3 = rs.getString("UserName");
            	 String str4 = rs.getString("Password");
            	 System.out.println(id + str1 + str2);
            	}
	    }
	    catch (Exception e) {
            e.printStackTrace();
        	}
	    }
}

