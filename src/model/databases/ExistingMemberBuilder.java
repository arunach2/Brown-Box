package model.databases;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import errors.InvalidLoginException;
import model.Member;
import model.dbConnections.ICreateDataBase;

public class ExistingMemberBuilder {

	String userName;
	String password;
	ICreateDataBase dataBase;

	public ExistingMemberBuilder (String userName, String password, ICreateDataBase dataBase) {
		this.userName = userName;
		this.password = password;
		this.dataBase =dataBase;
	}
	
	public Member run() throws InvalidLoginException {


		Member member = new Member();
		try {
            Connection con = dataBase.createConnection();
        	String query = "select * from Members where user_name = '" + userName + "'"
            		+ " and password = '" + password + "'";
        	Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);            

            if (rs.next()) {
            	 member.setMemberID(rs.getInt("member_id"));
            	 member.setFirstName(rs.getString("first_name"));
            	 member.setLastName(rs.getString("last_name"));
            	 member.setEmailAddress(rs.getString("email_address"));
            	 member.setUserName(rs.getString("user_name"));
            	 member.setPassword(rs.getString("password"));
            }
            
            else {
            	throw new InvalidLoginException("Invalid Login");
            	
            }
	    }
		
		catch (InvalidLoginException e) {
			// System.out.println(e.getMessage());
        	throw new InvalidLoginException("Invalid Login");
        }
	    
	    catch (Exception e) {
            e.printStackTrace();
	    }
		
		return member;
	}
}
