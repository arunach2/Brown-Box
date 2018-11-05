package model.databases;

import java.sql.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Statement;

import model.IMember;
import model.dbConnections.ICreateDataBase;

public class DateCheckedOut {
	
	IMember member;
	ICreateDataBase dataBase;
	
	public DateCheckedOut(IMember member, ICreateDataBase dataBase) {
		this.member = member;
		this.dataBase = dataBase;
	}
	
	public ArrayList<String> run() {
	    
	    int memberID = member.getMemberID();
	    ArrayList<String> listOfDates = new ArrayList<String>();
		
	    try {	    	
            Connection con = dataBase.createConnection();;
            Statement st = (Statement) con.createStatement();            
            String query2 = "select Date_Rented from RENTED_MOVIES where Member_ID = " + memberID;
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
            	Date dateRented = rs.getDate("Date_Rented");
            	listOfDates.add(dateRented.toString());            	
            }            
	    }	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return listOfDates;
	}
}
