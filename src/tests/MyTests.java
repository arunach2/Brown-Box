package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import errors.InvalidLoginException;
import model.ExistingMemberBuilder;
import model.ShoppingCart;
import model.databases.ListMovies;

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
