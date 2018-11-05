package model;

public class VideoGames implements IVideoGames {

    private int videoGameID;
    private String title;
    private double rating;
    private int year;
    private String genre;
    private String[] console;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }
    @Override
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public void setConsoles(String[] consoles) {
        this.console = consoles;
    }


    // getter methods
    // Should be created by auto-incrememneter
    @Override
    public int getID() {
        return videoGameID;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public double getRating() {
        return rating;
    }
    @Override
    public int getYear() {
        return year;
    }
    @Override
    public String getGenre() {
        return genre;
    }
    @Override
    public String[] getConsoles() {
        return console;
    }
}
