package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import errors.InvalidLoginException;
import model.Member;

public class CustomerGreeting {
	public Member greeting() {
		
		Scanner sc = new Scanner(System.in);
		
		LoadingMember loadingMemberCommand;
		while (true) {
			try {	
				System.out.println("Welcome to BrownBox!");
				System.out.println("Press 1 if you are a new member. Press 2 if you are an existing member.");
				int choice = sc.nextInt();
				if (choice == 1) {
					loadingMemberCommand = new SigningUpMember();
				}
				else if (choice == 2){
					loadingMemberCommand = new AccessingExistingMember();
				}
				else {
					
					throw new InputMismatchException();
				}
				// Close scanner as 
				sc.close();
				
				return loadingMemberCommand.run();
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
	}	
}
