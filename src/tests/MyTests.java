package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import errors.InvalidLoginException;
import model.ExistingMemberBuilder;
import model.ListMovies;
import model.ShoppingCart;

public class MyTests {

	@Test
	public void testInvalidCredentialsLogin() {
		try {
			new ExistingMemberBuilder().access("blah", "blah");
			fail("Did not throw InvalidLoginException");
		}
		
		catch (InvalidLoginException e){
			// If exception is thrown then we avoid the fail assert statement
		}
		
	}
}
