package model.databases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import model.IShoppingCart;
import model.Movie;
import model.dbConnections.ICreateDataBase;

public class ListCategoricalMovies implements IDatabaseAccesser{
	
	int choice;
	IShoppingCart shoppingCart;
	String category;
	ICreateDataBase dataBase;
	
	public ListCategoricalMovies(String category, IShoppingCart shoppingCart, ICreateDataBase dataBase) {
		this.choice = choice;
		this.shoppingCart = shoppingCart;
		this.category = category;
		this.dataBase = dataBase;
	}
	
	public void run() {
	    
	    try {
            Connection con = dataBase.createConnection();;
        	String query = "select * from movies where UPPER(genre) LIKE " + "'%" + category + "%'";
        	Statement st = (Statement) con.createStatement();
        	// Statement st2 = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);            
            
            while (rs.next()) {
				String title = String.format("%-30s", rs.getString("title"));
				String director = String.format("%-20s", rs.getString("director"));
				String genre = String.format("%-20s", rs.getString("genre"));
				String rating = String.format("%-5s", Double.toString(rs.getDouble("imdb_Rating")));
				//int year = rs.getInt("year");
				String year = String.format("%-10s", Integer.toString(rs.getInt("year")));
				System.out.println(title + director + genre + rating + year);
            }
            
            
            System.out.println("\nSelect the movies by the id listed next to it");
    	    Scanner sc = new Scanner(System.in);
    	    int movieID = sc.nextInt();
    	    query = "select * from movies where movie_id = " + movieID;
    	    rs = st.executeQuery(query);
    	    
    	    if (rs.next()) { 
    	    	String temp = rs.getString("Title");
    	    	
    	    	Movie movie = new MovieBuilder(temp, dataBase).run();
    	    	shoppingCart.addItem(movie);
    	    	
    	    }
    	    
	    }
		
		catch (Exception e) {
            e.printStackTrace();
	    }
	 
	}
}

