package model.databases;

import java.util.Iterator;

import model.IDigitalEntertainment;
import model.IShoppingCart;

public class ListCartItems implements IDatabaseAccesser {
	
	IShoppingCart shoppingCart;
	
	public ListCartItems(IShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public void run() {		
		Iterator<IDigitalEntertainment> cartIterator = shoppingCart.iterator();
		while(cartIterator.hasNext()) {
			IDigitalEntertainment item = cartIterator.next();
			System.out.println(item.getTitle() + " " + item.getCost());
		}
		
	}
}
