package main;

import java.util.Scanner;

import model.ListAllFines;
import model.Member;
import model.ShoppingCart;
import model.databases.Checkout;
import model.databases.IChoiceCommands;
import model.databases.ListCartItems;
import model.databases.ListCategoricalMovies;
import model.databases.ListMovies;
import model.databases.ListCheckedOutMoviesInfo;
import view.CustomerChoices;
import view.CustomerGreeting;

public class CustomerInteraction {
	public static void main(String[] Args) {
		
		// Greets customer at the beginning of the program
		Member member = new CustomerGreeting().greeting();
		
		System.out.println("Welcome " + member.getFirstName() + "!");
		
		Scanner sc = new Scanner(System.in);
		// Instantiate shoppingCart
		ShoppingCart shoppingCart = new ShoppingCart();
		int topic = 0;
		IChoiceCommands command = null;
		// Going to have to account for potential non-integer input from user (try-catch block)
		while (topic != 9) {
			
			CustomerChoices.print();
			topic = sc.nextInt();
			if (topic == 1) {
				command = new ListMovies(shoppingCart);
			}
			else if (topic > 1 && topic < 7) {
				command = new ListCategoricalMovies(topic, shoppingCart);
			}
			
			else if (topic == 7){
				command = new ListCartItems(shoppingCart);
			}
			
			else if (topic == 8) {
				command = new ListAllFines(member, shoppingCart);
			}
			
			else if (topic == 9) {
				command = new ListCheckedOutMoviesInfo(member);
			}
			
			else if (topic == 10) {
				command = new Checkout(member, shoppingCart);
			}
			else {
				System.out.println("Invalid Command");
			}			
			command.run();
		}		
		sc.close();
		System.out.println("Your total is $"+ String.format("%.2f", shoppingCart.getTotalCost()) + ".");
		System.out.println("Reminder: Movies are due 7 days after they are rented. Thank you for shopping with us!");
	}	
}