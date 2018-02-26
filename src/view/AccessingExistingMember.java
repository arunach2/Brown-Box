package view;

import java.util.Scanner;

import errors.InvalidLoginException;
import model.Member;
import model.ExistingMemberBuilder;

public class AccessingExistingMember {
	
	public static Member initiate() throws InvalidLoginException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your username?");
		String userName = sc.nextLine();
		System.out.println("What is your password?");
		String password = sc.nextLine();
		
		return ExistingMemberBuilder.access(userName, password);
		
	}
}
