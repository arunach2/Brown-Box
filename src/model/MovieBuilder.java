package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class MovieBuilder {
	
	public static Movie build(String title) {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
		Movie movie = new Movie();
		
	    try {
            Connection con = DriverManager.getConnection(url, user, password);
            
            String query = "select * from MOVIE where Title = '" + title + "'";
            
            Statement st = (Statement) con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) { 
            	movie.setID(rs.getInt("MovieID"));
            	movie.setTitle(title);
            	movie.setDirector(rs.getString("Director"));
		    	movie.setGenre(rs.getString("Genre"));
		    	movie.setImdbRating(rs.getDouble("IMDb_Rating"));
		    	movie.setYear(rs.getInt("Year"));
		    	movie.setCost();
            }  
	    }
	    
	    catch (Exception e) {
            e.printStackTrace();
        	}
	    
	    return movie;
	}
}
