package model;

public class Movie implements IDigitalEntertainment{

	// Movie table also has a primary key MovieID
	private int movieID;
	private String director;
	private String title;
	private String genre;
	private int year;
	private double imdbRating;
	private double cost;
	
	public void setID(int movieID) {
		this.movieID = movieID;
	}
	
	@Override
	public void setDirector(String director) {
		this.director = director;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public int getID() {
		return movieID;
	}
	@Override
	public double getCost() {
		if (2018 == year) {cost = 3.00;}
		else if (2018 - year == 1) {cost = 2.50;}
		else {cost = 1.50;}
		return cost;
	}
	@Override
	public String getDirector() {
		return director;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public String getGenre() {
		return genre;
	}
	@Override
	public int getYear() {
		return year;
	}
	@Override
	public double getImdbRating() {
		return imdbRating;
	}
}
