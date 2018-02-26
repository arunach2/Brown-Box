package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ListCheckedOutMovies {
	public static ArrayList<String> list(Member member) {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
	    ArrayList<String> movieList = new ArrayList<String>();
	    
	    
	    try {	    	
            Connection con = DriverManager.getConnection(url, user, password);            
            Statement st = (Statement) con.createStatement();            
            String query2 = "select RENTED_MOVIES.MemberID, MOVIE.Title from RENTED_MOVIES "
            		+ "inner join MOVIE on MOVIE.MovieID = RENTED_MOVIES.MovieID "
            		+ "where MemberID = " + member.getMemberID();
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
