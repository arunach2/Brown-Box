package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Checkout {
	public static void check(Member member, ShoppingCart shoppingCart) {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
	    try {
            Connection con = DriverManager.getConnection(url, user, password);
            int memberID = member.getMemberID();
            int movieID = 0;            
            
            Statement st = (Statement) con.createStatement();            
           
            for (int i = 0; i < shoppingCart.getSize(); i++) {
            	
            	movieID = shoppingCart.getItem(i).getID();	        	
	            
	        	String query2 = "insert into RENTED_MOVIES values (?, ?, ?)";
	        	
	        	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query2);
	        	preparedStatement.setInt(1, movieID);
	        	preparedStatement.setInt(2, memberID);	        	
	        	preparedStatement.setDate(3, java.sql.Date.valueOf("2018-02-04"));       	
	        	preparedStatement.executeUpdate();
            }
            
	    }
	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	}
}
