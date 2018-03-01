package model.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import model.IShoppingCart;
import model.Movie;
import model.MovieBuilder;
import model.ShoppingCart;

public class ListMovies implements IDatabaseAccesser{
	
	IShoppingCart shoppingCart;
	
	public ListMovies(IShoppingCart shoppingCart) {		
		this.shoppingCart = shoppingCart;
	}

	public void run() {
		
		String url = "jdbc:mysql://localhost:3306/BrownBox";
		String user = "root";
	    String password = "Hog123er";
	    
	    try {
            Connection con = DriverManager.getConnection(url, user, password);                        
        	String query = "select * from MOVIE";
        	Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);            
            
            while (rs.next()) { 
            	String title = rs.getString("Title"); 
            	String director = rs.getString("Director");
           	 	String genre = rs.getString("Genre");
           	 	double rating = rs.getDouble("IMDb_Rating");
           	 	int year = rs.getInt("Year");
           	 	System.out.println(title + " " + director + " " + genre
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