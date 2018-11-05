package model.databases;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.IMember;
import model.IShoppingCart;
import model.dbConnections.CreateBrownBoxDataBase;
import model.dbConnections.ICreateDataBase;

public class Checkout implements IDatabaseAccesser {
	
	IMember member;
	IShoppingCart shoppingCart;
	ICreateDataBase dataBase;
	
	public Checkout(IMember member, IShoppingCart shoppingCart, ICreateDataBase dataBase) {
		this.member = member;
		this.shoppingCart = shoppingCart;
		this.dataBase = dataBase;
	}
	
 	public void run() {
	    
	    try {
            Connection con = dataBase.createConnection();;
            int memberID = member.getMemberID();

            Statement st = (Statement) con.createStatement();            
           
            for (int i = 0; i < shoppingCart.getSize(); i++) {
            	
            	int movieID = shoppingCart.getItem(i).getID();
	            
	        	String query2 = "insert into RENTED_MOVIES values (?, ?, ?)";
	        	
	        	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query2);
	        	preparedStatement.setInt(1, memberID);
	        	preparedStatement.setInt(2, movieID);
	        	preparedStatement.setDate(3, java.sql.Date.valueOf("2018-02-04"));       	
	        	preparedStatement.executeUpdate();
            }
            
	    }
	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	}
}
