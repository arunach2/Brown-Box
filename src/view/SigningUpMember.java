package view;

import java.util.Scanner;

import model.Member;
import model.NewMemberBuilder;

public class SigningUpMember implements LoadingMember {
	
	public Member run() {
		
		Member member = new Member();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Answer five questions so you can officially be a member of the BrownBox family!");
		
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
		
		NewMemberBuilder.initialize(member);
		return member;
	}
}
