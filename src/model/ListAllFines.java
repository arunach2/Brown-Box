package model;

public class ListAllFines {
	public static void listfines(Member member, ShoppingCart shoppingCart) {
		double fines = CheckFines.checkFines(member);
		double cartCosts = shoppingCart.getTotalCost();
		double totalCosts = fines + cartCosts;
		System.out.println("Your cost for your current cart is $" + String.format("%.2f", cartCosts) + ".");
		System.out.println("Your fine is $" 
				+ String.format("%.2f", fines) + ".");
		System.out.println("Your total costs at checkout will be $" + String.format("%.2f", totalCosts) + ".");
	}
}
