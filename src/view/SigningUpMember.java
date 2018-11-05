package view;

import java.util.Scanner;

import errors.AlreadyExistingMemberException;
import model.Member;
import model.databases.NewMemberBuilder;
import model.dbConnections.ICreateDataBase;

public class SigningUpMember implements LoadingMember {

	ICreateDataBase dataBase;

	public SigningUpMember(ICreateDataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	public Member run() throws AlreadyExistingMemberException {
		
		Member member = new Member();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Answer five questions so you can officially be a member of the Brown Box family!");
		
		System.out.println("What is your first name?");		
		member.setFirstName(sc.nextLine());
		
		System.out.println("What is your last name?");
		member.setLastName(sc.nextLine());
		
		System.out.println("What is your email address?");
		member.setEmailAddress(sc.nextLine());
		
		System.out.println("What is your username?");
		member.setUserName(sc.nextLine());
		
		System.out.println("What is your password?");
		member.setPassword(sc.nextLine());
		
		new NewMemberBuilder(member, dataBase).run();
		return member;
	}
}
