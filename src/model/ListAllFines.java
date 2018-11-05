package model;

import model.databases.CheckFines;
import model.databases.IDatabaseAccesser;
import model.dbConnections.ICreateDataBase;

public class ListAllFines implements IDatabaseAccesser{
	
	IMember member;
	IShoppingCart shoppingCart;
	ICreateDataBase dbConnection;
	
	public ListAllFines(IMember member, IShoppingCart shoppingCart, ICreateDataBase dbConnection) {
		this.member = member;
		this.shoppingCart = shoppingCart;
		this.dbConnection = dbConnection;
	}
	public void run() {
		double fines = new CheckFines(member, dbConnection).run();
		double cartCosts = shoppingCart.getTotalCost();
		double totalCosts = fines + cartCosts;
		System.out.println("Your cost for your current cart is $" + String.format("%.2f", cartCosts) + ".");
		System.out.println("Your fine is $" 
				+ String.format("%.2f", fines) + ".");
		System.out.println("Your total costs at checkout will be $" + String.format("%.2f", totalCosts) + ".");
	}
}
