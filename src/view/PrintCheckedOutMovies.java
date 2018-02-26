package view;

import java.util.ArrayList;

import model.DateCheckedOut;
import model.ListCheckedOutMovies;
import model.Member;

public class PrintCheckedOutMovies {
	public static void print(Member member) {
		ArrayList<String> checkedOutMovies;
		checkedOutMovies = ListCheckedOutMovies.list(member);
		ArrayList<String> listOfDates;
		listOfDates = DateCheckedOut.getDates(member);
		for (int i = 0; i < checkedOutMovies.size(); i++) {
			System.out.println("You have already checked out " + checkedOutMovies.get(i) 
			+ " on " + listOfDates.get(i) + ".");
		}
		
	}
}
