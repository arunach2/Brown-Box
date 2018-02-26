package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import errors.InvalidLoginException;
import model.Member;

public class CustomerGreeting {
	public static Member greeting() {
		
		Scanner sc = new Scanner(System.in);
		
		Member member = null;
		while (true) {
			try {	
				System.out.println("Welcome to BrownBox!");
				System.out.println("Press 1 if you are a new member. Press 2 if you are an existing member.");
				int choice = sc.nextInt();
				if (choice == 1) {
					member = SigningUpMember.initiate();
					break;
				}
				else if (choice == 2){
					member = AccessingExistingMember.initiate();
					break;
				}
				else {
					
					throw new InputMismatchException();
				}
			}
			
			catch (InputMismatchException e) {
				System.out.println("Invalid entry!");
				System.out.println("Try again!");
				sc.next();
				continue;
			}
			
			catch (InvalidLoginException e) {
				System.out.println("Invalid login!");
				System.out.println("Try again!");
				// sc.next();
				continue;
			}
			
			catch(Exception e) {
				System.out.println("Bug in the code");
				sc.next();
				continue;
				// return;
			}
		}
		return member;
	}	
}
