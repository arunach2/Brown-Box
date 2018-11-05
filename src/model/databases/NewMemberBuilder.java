package model.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import errors.AlreadyExistingMemberException;
import model.IMember;
import model.dbConnections.ICreateDataBase;

public class NewMemberBuilder {
	
	IMember member;
	ICreateDataBase dataBase;
	
	public NewMemberBuilder(IMember member, ICreateDataBase dataBase) {
		this.member = member;
		this.dataBase = dataBase;
	}
	
	public void run() throws AlreadyExistingMemberException {
		try {

            Connection con = dataBase.createConnection();

			String query0 = "select * from Members where email_address = '" + member.getEmailAddress() + "'";
			Statement st2 = (Statement) con.createStatement();
			ResultSet rs2 = st2.executeQuery(query0);

			if (rs2.next()) {
				throw new AlreadyExistingMemberException("This email address is already being used");
			}
            
        	String query = "insert into Members values (default, ?,"
        			+ "?,?,?,?)";
        	
        	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
        	preparedStatement.setString(1, member.getFirstName());
        	preparedStatement.setString(2, member.getLastName());
        	preparedStatement.setString(3, member.getUserName());
        	preparedStatement.setString(4, member.getPassword());
        	preparedStatement.setString(5, member.getEmailAddress());
        	
        	preparedStatement.executeUpdate();
        	
        	String query2 = "select * from Members where user_name = '" + member.getUserName() + "'"
            		+ " and Password = '" + member.getPassword() + "'";
        	Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query2);
            
            if (rs.next()) {
            	member.setMemberID(rs.getInt("Member_ID"));
            }            
            
	    }

	    catch (AlreadyExistingMemberException e) {
			System.out.println(e.getMessage());
			throw e;
		}
		
		catch (SQLException e) {
			System.out.println(e);
        	System.out.println("Invalid Entry information.");
        }
	    
	    catch (Exception e) {
            e.printStackTrace();
	    }			    
	}
}
