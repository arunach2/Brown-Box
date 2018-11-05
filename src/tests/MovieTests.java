package tests;

import static org.junit.Assert.*;

import errors.InvalidLoginException;
import model.IDigitalEntertainment;
import model.Movie;
import model.ShoppingCart;
import model.databases.ExistingMemberBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class MovieTests {

    private Movie makeMockMovie () {
        Movie mock = new Movie();
        mock.setYear(2015);
        mock.setDirector("Carl");
        mock.setGenre("Comedy");
        mock.setID(3);
        mock.setImdbRating(7.8);
        mock.setTitle("40 Year Old Virgin");
        return mock;
    }

    @Test
    public void testGetYear() {
        Movie mock = makeMockMovie();
        assertEquals(2015, mock.getYear());
    }

    @Test
    public void testGetDirector() {
        Movie mock = makeMockMovie();
        assertEquals("Carl", mock.getDirector());
    }

    @Test
    public void testGetGenre() {
        Movie mock = makeMockMovie();
        assertEquals("Comedy", mock.getGenre());
    }

    @Test
    public void testGetID() {
        Movie mock = makeMockMovie();
        assertEquals(3, mock.getID());
    }

    @Test
    public void testGetImdbRating() {
        Movie mock = makeMockMovie();
        assertEquals(7.8, mock.getImdbRating(), 0);
    }

    @Test
    public void testTitle() {
        Movie mock = makeMockMovie();
        assertEquals("40 Year Old Virgin", mock.getTitle());
    }

    @Test
    public void testGetCost() {
        Movie mock = makeMockMovie();
        assertEquals(1.5, mock.getCost(), 0);
    }

}
