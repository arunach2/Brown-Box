package model.databases;

import java.sql.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.IMember;
import model.dbConnections.ICreateDataBase;

public class ListCheckedOutMovies {
	
	IMember member;
	ICreateDataBase dataBase;
	
	public ListCheckedOutMovies(IMember member, ICreateDataBase dataBase) {
		this.member = member;
		this.dataBase = dataBase;
	}
	public ArrayList<String> run() {
	    
	    ArrayList<String> movieList = new ArrayList<String>();
	    
	    
	    try {	    	
            Connection con = dataBase.createConnection();;
            Statement st = (Statement) con.createStatement();            
            String query2 = "select RENTED_MOVIES.Member_ID, movies.Title from RENTED_MOVIES "
            		+ "inner join movies on movies.Movie_ID = RENTED_MOVIES.Movie_ID "
            		+ "where Member_ID = " + member.getMemberID();
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
            	movieList.add(rs.getString("Title"));            	
            }            
	    }
	    
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return movieList;
	}
}
