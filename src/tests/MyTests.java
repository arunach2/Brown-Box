package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import errors.InvalidLoginException;
import model.ExistingMemberBuilder;
import model.IMember;
import model.Member;
import model.ShoppingCart;
import model.databases.ListCheckedOutMovies;
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
	
	@Test
	public void checkingDatesOnMemberWhoHasNothingCheckedOut () {
		// should return empty list
		
		// Create demoMember
		IMember member = new Member();
		member.setEmailAddress(null);
		member.setFirstName(null);
		member.setLastName(null);
		member.setMemberID(0);
		member.setPassword(null);
		member.setUserName(null);
		
		try {
			ArrayList<String> checkedOutMovies = new ListCheckedOutMovies(member).run();
			assertEquals(0, checkedOutMovies.size());
		}
		
		catch (Exception e) {
			fail();
		}
	}
}
