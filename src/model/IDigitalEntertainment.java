package model;

public interface IDigitalEntertainment {
	
	public void setID(int movieID);
	public void setCost();
	public void setDirector(String director);
	public void setTitle(String title);
	public void setGenre(String genre);
	public void setYear(int year);
	public void setImdbRating(double imdbRating);
	
	public int getID();
	public double getCost();
	public String getDirector();
	public String getTitle();
	public String getGenre();
	public int getYear();
	public double getImdbRating();
	
}
