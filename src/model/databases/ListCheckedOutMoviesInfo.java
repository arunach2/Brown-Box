package model.databases;

import java.util.ArrayList;

import model.IMember;
import model.Member;

public class ListCheckedOutMoviesInfo implements IDatabaseAccesser {
	
	IMember member;
	
	public ListCheckedOutMoviesInfo(IMember member) {
		this.member = member;
	}
	public void run() {
		ArrayList<String> checkedOutMovies;
		checkedOutMovies = new ListCheckedOutMovies(member).run();
		ArrayList<String> listOfDates;
		listOfDates = new DateCheckedOut(member).run();
		System.out.println(checkedOutMovies);
		if (checkedOutMovies.size()  == 0) {
			System.out.println("You have no checked out movies.");
		}
		else {
			for (int i = 0; i < checkedOutMovies.size(); i++) {
				System.out.println("You have already checked out " + checkedOutMovies.get(i) 
				+ " on " + listOfDates.get(i) + ".");
			}
		}
		
		
	}
}
