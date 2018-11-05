package model.databases;

import java.util.ArrayList;

import model.IMember;
import model.dbConnections.ICreateDataBase;

public class ListCheckedOutMoviesInfo implements IDatabaseAccesser {
	
	IMember member;
	ICreateDataBase dataBase;
	
	public ListCheckedOutMoviesInfo(IMember member, ICreateDataBase dataBase) {
		this.member = member;
		this.dataBase = dataBase;
	}
	public void run() {
		ArrayList<String> checkedOutMovies;
		checkedOutMovies = new ListCheckedOutMovies(member, dataBase).run();
		ArrayList<String> listOfDates;
		listOfDates = new DateCheckedOut(member, dataBase).run();
		if (checkedOutMovies.size()  == 0) {
			System.out.println("You have no checked out movies.");
		}
		else {
			System.out.println(checkedOutMovies);
			for (int i = 0; i < checkedOutMovies.size(); i++) {
				System.out.println("You have already checked out " + checkedOutMovies.get(i)
						+ " on " + listOfDates.get(i) + ".");
			}
		}
		
		
	}
}
