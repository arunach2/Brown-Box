package model.databases;

import java.util.ArrayList;

import model.IMember;
import model.Member;

public class ListCheckedOutMoviesInfo implements IChoiceCommands{
	
	IMember member;
	
	public ListCheckedOutMoviesInfo(IMember member) {
		this.member = member;
	}
	public void run() {
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
