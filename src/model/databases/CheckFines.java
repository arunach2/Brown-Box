package model.databases;

import java.sql.Connection;

import java.sql.ResultSet;
import java.util.Date;

import com.mysql.jdbc.Statement;

import model.IMember;
import model.dbConnections.ICreateDataBase;

public class CheckFines {
	
	IMember member;
	ICreateDataBase dataBase;
	
	public CheckFines(IMember member, ICreateDataBase dataBase) {
		this.member = member;
		this.dataBase = dataBase;

	}
	public double run() {
	    
	    int memberID = member.getMemberID();
    	double totalFines = 0.0;
	    
	    try {	    	
            Connection con = dataBase.createConnection();
            Statement st = (Statement) con.createStatement();            
            String query2 = "select Date_Rented from RENTED_MOVIES where Member_ID = " + memberID;
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
            	Date dateRented = rs.getDate("Date_Rented");
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
