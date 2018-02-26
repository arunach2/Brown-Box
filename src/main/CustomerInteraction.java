package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

import model.CheckFines;
import model.Checkout;
import model.ListAllFines;
import model.ListCategoricalMovies;
import model.ListMovies;
import model.Member;
import model.ShoppingCart;
import view.CustomerChoices;
import view.CustomerGreeting;
import view.PrintCheckedOutMovies;

public class CustomerInteraction {
	public static void main(String[] Args) {
		
		// Greets customer at the beginning of the program
		Member member = new CustomerGreeting().greeting();
		
		// Need to still encapsulate this behavior
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome " + member.getFirstName() + "!");
		ShoppingCart shoppingCart = new ShoppingCart();
		int topic = 0;					
		while (topic != 9) {
			
			CustomerChoices.print();
			topic = sc.nextInt();
			if (topic == 1) {
				ListMovies.access(shoppingCart);
			}
			else if (topic > 1 && topic < 7) {
				ListCategoricalMovies.access(topic, shoppingCart);
			}
			
			else if (topic == 7){
				shoppingCart.printItems();
			}
			
			else if (topic == 8) {
				ListAllFines.listfines(member, shoppingCart);
				PrintCheckedOutMovies.print(member);
			}
			
			else if (topic == 9) {
				Checkout.check(member, shoppingCart);
				System.out.println("Your total is $"+ String.format("%.2f", shoppingCart.getTotalCost()) + ".");
				System.out.println("Reminder: Movies are due 7 days after they are rented. Thank you for shopping with us!");
				
				
			}
		}
		
	}

	
}
