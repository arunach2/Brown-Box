package model;

import java.util.ArrayList;

public class ShoppingCart {
	
	ArrayList<IDigitalEntertainment> shoppingCart;
	
	public ShoppingCart() {
		this.shoppingCart =  new ArrayList<IDigitalEntertainment>();
	}
	
	public void printItems() {
		for (IDigitalEntertainment item: shoppingCart) {
			System.out.println(item.getTitle() + " " + item.getCost());
		}
	}
	
	public void addItem(IDigitalEntertainment item) {
		shoppingCart.add(item);
	}
	
	public IDigitalEntertainment getItem(int index) {
		return shoppingCart.get(index);
	}
	
	public void removeItem(int itemNo) {
		shoppingCart.remove(itemNo - 1);
	}
	
	public int getSize() {
		return shoppingCart.size();
	}
	
	public double getTotalCost() {
		double total = 0.0;
		for (IDigitalEntertainment item: shoppingCart) {
			total += item.getCost();
		}		
		return total;
	}
	
	
}
