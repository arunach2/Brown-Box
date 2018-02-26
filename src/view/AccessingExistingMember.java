package view;

import java.util.Scanner;

import errors.InvalidLoginException;
import model.Member;
import model.ExistingMemberBuilder;

public class AccessingExistingMember implements LoadingMember{
	
	public Member run() throws InvalidLoginException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your username?");
		String userName = sc.nextLine();
		System.out.println("What is your password?");
		String password = sc.nextLine();
		
		return new ExistingMemberBuilder().access(userName, password);
		
	}
}
