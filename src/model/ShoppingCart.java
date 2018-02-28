package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart implements IShoppingCart{
	
	ArrayList<IDigitalEntertainment> shoppingCart;
	
	public ShoppingCart() {
		this.shoppingCart =  new ArrayList<IDigitalEntertainment>();
	}
	
	public Iterator<IDigitalEntertainment> iterator() {
		return shoppingCart.iterator();
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
