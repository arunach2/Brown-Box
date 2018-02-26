package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import errors.InvalidLoginException;

public class ExistingMemberBuilder {
	
	public Member access(String userName, String password_access) throws InvalidLoginException {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
		Member member = new Member();
		
		try {
            Connection con = DriverManager.getConnection(url, user, password);                        
        	String query = "select * from MEMBER where Username = '" + userName + "'"
            		+ " and Password = '" + password_access + "'";
        	Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);            

            if (rs.next()) {
            	 member.setMemberID(rs.getInt("MemberID"));
            	 member.setFirstName(rs.getString("FirstName"));
            	 member.setLastName(rs.getString("LastName"));
            	 member.setEmailAddress(rs.getString("EmailAddress"));            	 
            	 member.setUserName(rs.getString("Username"));
            	 member.setPassword(rs.getString("Password"));            	 
            }
            
            else {
            	throw new InvalidLoginException();
            	
            }
	    }
		
		catch (InvalidLoginException e) {
        	throw new InvalidLoginException();        	
        }
	    
	    catch (Exception e) {
            e.printStackTrace();
	    }
		
		return member;
	}
}
