package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class ListCategoricalMovies {
public static void access(int choice, ShoppingCart shoppingCart) {
	
		String category;
		switch(choice)	{
			case 2:
				category = "comedy";
				break;
			case 3:
				category = "action";
				break;
			case 4:
				category = "documentary";
				break;
			case 5:
				category = "romantic";
				break;
			case 6:
				category = "sports";
				break;
			default:
				category = "";
				break;
			
		}		
			
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
	    try {
            Connection con = DriverManager.getConnection(url, user, password);                        
        	String query = "select * from MOVIE where Genre = '" + category + "'";
        	Statement st = (Statement) con.createStatement();
        	// Statement st2 = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);            
            
            while (rs.next()) {
            	int id = rs.getInt("MovieID");
            	String title = rs.getString("Title"); 
            	String director = rs.getString("Director");
           	 	String genre = rs.getString("Genre");
           	 	double rating = rs.getDouble("IMDb_Rating");
           	 	int year = rs.getInt("Year");
           	 	System.out.println(id + " " + title + " " + director + " " + genre
           	 			+ " " + rating + " " + year);
            }
            
            
            System.out.println("\nSelect the movie by the id listed next to it");
    	    Scanner sc = new Scanner(System.in);
    	    int movieID = sc.nextInt();
    	    query = "select * from MOVIE where MovieID = " + movieID;
    	    rs = st.executeQuery(query);
    	    
    	    if (rs.next()) { 
    	    	String temp = rs.getString("Title");
    	    	
    	    	Movie movie = MovieBuilder.build(temp);
    	    	shoppingCart.addItem(movie);
    	    	
    	    }
    	    
	    }
		
		catch (Exception e) {
            e.printStackTrace();
	    }
	 
	}
}

