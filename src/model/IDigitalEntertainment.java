package model;

public interface IDigitalEntertainment {
	
	void setID(int movieID);
	void setDirector(String director);
	void setTitle(String title);
	void setGenre(String genre);
	void setYear(int year);
	void setImdbRating(double imdbRating);
	
	public int getID();
	public double getCost();
	public String getDirector();
	public String getTitle();
	public String getGenre();
	public int getYear();
	public double getImdbRating();
	
}
