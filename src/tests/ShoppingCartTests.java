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


public class ShoppingCartTests {

	public ShoppingCart createMockShoppingCart () {
		ArrayList<IDigitalEntertainment> temp = new ArrayList<IDigitalEntertainment> ();
		Movie movie1 = new Movie();
		Movie movie2 = new Movie();
		movie1.setYear(2015);
		movie2.setYear(2016);
		temp.add(movie1);
		temp.add(movie2);
		return new ShoppingCart(temp);
	}

	@org.junit.jupiter.api.Test
	public void testGetSize() {
		ShoppingCart mock = createMockShoppingCart();
		int size = mock.getSize();
		assertEquals(2, size);
	}

	@org.junit.jupiter.api.Test
	public void testAddItem() {
		ShoppingCart mock = createMockShoppingCart();
		mock.addItem(new Movie());
		assertEquals(3, mock.getSize());
	}

	@org.junit.jupiter.api.Test
	public void testRemoveItem() {
		ShoppingCart mock = createMockShoppingCart();
		mock.removeItem(2);
		assertEquals(1, mock.getSize());
	}

	@org.junit.jupiter.api.Test
	public void testGetItem() {
		ShoppingCart mock = createMockShoppingCart();
		assertNotNull(mock.getItem(0));
	}

	@org.junit.jupiter.api.Test
	public void testGetTotalCost() {
		ShoppingCart mock = createMockShoppingCart();
		assertEquals(3.0, mock.getTotalCost(), 0);
	}
}