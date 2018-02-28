package model;

import model.databases.CheckFines;
import model.databases.IChoiceCommands;

public class ListAllFines implements IChoiceCommands{
	
	IMember member;
	IShoppingCart shoppingCart;
	
	public ListAllFines(IMember member, IShoppingCart shoppingCart) {
		this.member = member;
		this.shoppingCart = shoppingCart;
	}
	public void run() {
		double fines = CheckFines.checkFines(member);
		double cartCosts = shoppingCart.getTotalCost();
		double totalCosts = fines + cartCosts;
		System.out.println("Your cost for your current cart is $" + String.format("%.2f", cartCosts) + ".");
		System.out.println("Your fine is $" 
				+ String.format("%.2f", fines) + ".");
		System.out.println("Your total costs at checkout will be $" + String.format("%.2f", totalCosts) + ".");
	}
}
