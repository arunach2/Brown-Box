package model;

public interface IVideoGames {
    // setter methods
    void setTitle(String title);
    void setRating(double rating);
    void setYear(int year);
    void setGenre(String genre);
    void setConsoles(String[] consoles);


    // getter methods
    // Should be created by auto-incrememneter
    int getID();
    String getTitle();
    double getRating();
    int getYear();
    String getGenre();
    String[] getConsoles();

}
