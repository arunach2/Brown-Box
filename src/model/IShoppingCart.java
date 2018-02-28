package model;

import java.util.Iterator;

public interface IShoppingCart {

	public void addItem(IDigitalEntertainment item);
	public IDigitalEntertainment getItem(int index);
	public void removeItem(int itemNo);
	public int getSize();
	public double getTotalCost();
	public Iterator<IDigitalEntertainment> iterator();
	
}
