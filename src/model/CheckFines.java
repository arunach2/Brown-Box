package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CheckFines {
	public static double checkFines(Member member) {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
	    int memberID = member.getMemberID();
    	double totalFines = 0.0;
	    
	    try {	    	
            Connection con = DriverManager.getConnection(url, user, password);            
            Statement st = (Statement) con.createStatement();            
            String query2 = "select DateRented from RENTED_MOVIES where MemberID = " + memberID;
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
            	Date dateRented = rs.getDate("DateRented");
            	Date currentDate = new Date();
            	int daysBetween = daysBetween(currentDate, dateRented);
            	totalFines += fines(daysBetween);
            }            
	    }
	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return totalFines;
        
	}
	
	private static int daysBetween(Date one, Date two) { 
		long difference = (one.getTime()-two.getTime())/86400000; 
		return (int) Math.abs(difference); 
	}
	
	private static double fines(int daysOverdue) {
		double fine = 0.0;
		if (daysOverdue > 7) {
			fine = daysOverdue * 1.00;
		}
		return fine;		
	}

	
}
