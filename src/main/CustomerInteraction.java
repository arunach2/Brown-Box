package main;

import java.util.Scanner;

import model.ListAllFines;
import model.Member;
import model.ShoppingCart;
import model.databases.Checkout;
import model.databases.IDatabaseAccesser;
import view.ListCartItems;
import model.databases.ListCategoricalMovies;
import model.databases.ListMovies;
import model.databases.ListCheckedOutMoviesInfo;
import model.dbConnections.CreateBrownBoxDataBase;
import model.dbConnections.ICreateDataBase;
import view.CustomerChoices;
import view.CustomerGreeting;
import view.SelectCategory;

public class CustomerInteraction {
	public static void main(String[] Args) {
		ICreateDataBase dataBase = new CreateBrownBoxDataBase();
		// Greets customer at the beginning of the program
		Member member = CustomerGreeting.greeting(dataBase);
		
		System.out.println("Welcome " + member.getFirstName() + "!");
		
		Scanner sc = new Scanner(System.in);
		// Instantiate shoppingCart
		ShoppingCart shoppingCart = new ShoppingCart();
		int topic = 0;
		IDatabaseAccesser command = null;

		// Going to have to account for potential non-integer input from user (try-catch block)
		while (topic != 6 && topic != 7) {
			
			CustomerChoices.print();
			topic = sc.nextInt();
			if (topic == 1) {
				command = new ListMovies(shoppingCart, dataBase);
			}
			else if (topic == 2) {
				String category = SelectCategory.listCategories();
				command = new ListCategoricalMovies(category, shoppingCart, dataBase);
			}
			
			else if (topic == 3){
				command = new ListCartItems(shoppingCart);
			}
			
			else if (topic == 4) {
				command = new ListAllFines(member, shoppingCart, dataBase);
			}
			
			else if (topic == 5) {
				command = new ListCheckedOutMoviesInfo(member, dataBase);
			}
			
			else if (topic == 6) {
				command = new Checkout(member, shoppingCart, dataBase);
				System.out.println("Your total is $"+ String.format("%.2f", shoppingCart.getTotalCost()) + ".");
				System.out.println("Reminder: Movies are due 7 days after they are rented. Thank you for shopping with us!");
			}
			else if (topic == 7) {
				System.out.println("Hope to see you again soon!");
			}

			else {
				System.out.println("Invalid Command");
			}

			if (topic >= 1 && topic <= 6) {
				command.run();
			}

		}
	}	
}