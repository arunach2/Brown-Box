package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.databases.IDatabaseAccesser;

public class NewMemberBuilder implements IDatabaseAccesser {
	
	IMember member;
	
	public NewMemberBuilder(IMember member) {
		this.member = member;
	}
	
	public void run() {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
		try {
            Connection con = DriverManager.getConnection(url, user, password);
            
        	String query = "insert into MEMBER values (default, ?,"
        			+ "?,?,?,?)";
        	
        	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
        	preparedStatement.setString(1, member.getFirstName());
        	preparedStatement.setString(2, member.getLastName());
        	preparedStatement.setString(3, member.getUserName());
        	preparedStatement.setString(4, member.getPassword());
        	preparedStatement.setString(5, member.getEmailAddress());
        	
        	preparedStatement.executeUpdate();
        	
        	String query2 = "select * from MEMBER where Username = '" + member.getUserName() + "'"
            		+ " and Password = '" + member.getPassword() + "'";
        	Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query2);
            
            if (rs.next()) {
            	member.setMemberID(rs.getInt("MemberID"));
            }            
            
	    }
		
		catch (SQLException e) {
        	System.out.println("Invalid Entry information.");
        }
	    
	    catch (Exception e) {
            e.printStackTrace();
	    }			    
	}
}
