package model.databases;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import model.Movie;
import model.dbConnections.CreateBrownBoxDataBase;
import model.dbConnections.ICreateDataBase;

public class MovieBuilder {

	String title;
	ICreateDataBase dataBase;

	public MovieBuilder (String title, ICreateDataBase dataBase) {
		this.title = title;
		this.dataBase = dataBase;
	}

	
	public Movie run() {
	    
		Movie movie = new Movie();
		
	    try {
            Connection con = dataBase.createConnection();
            String query = "select * from movies where title = '" + title + "'";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) { 
            	movie.setID(rs.getInt("Movie_ID"));
            	movie.setTitle(title);
            	movie.setDirector(rs.getString("Director"));
		    	movie.setGenre(rs.getString("Genre"));
		    	movie.setImdbRating(rs.getDouble("IMDb_Rating"));
		    	movie.setYear(rs.getInt("Year"));
            }  
	    }
	    
	    catch (Exception e) {
            e.printStackTrace();
        	}
	    
	    return movie;
	}
}
