package model.databases;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.IMember;
import model.Member;

public class DateCheckedOut {
	public static ArrayList<String> getDates(IMember member) {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
	    int memberID = member.getMemberID();
	    ArrayList<String> listOfDates = new ArrayList<String>();
		
	    try {	    	
            Connection con = DriverManager.getConnection(url, user, password);            
            Statement st = (Statement) con.createStatement();            
            String query2 = "select DateRented from RENTED_MOVIES where MemberID = " + memberID;
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
            	Date dateRented = rs.getDate("DateRented");
            	listOfDates.add(dateRented.toString());            	
            }            
	    }	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return listOfDates;
	}
}
