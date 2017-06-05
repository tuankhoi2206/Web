package model;

import java.util.ArrayList;

/*
 * Java reflaction phải có set/get cho property
 */
public class ShoppingCart {

	/*
	 * 
	 */
	private ArrayList<Item> listItem;

	private Customer customer;

	public ShoppingCart() {
		this(new ArrayList<Item>(), new Customer());
	}

	public ShoppingCart(ArrayList<Item> listItem, Customer customer) {
		super();
		this.listItem = listItem;
		this.customer = customer;
	}

	public void addItem(Item item) {
		if (item != null && !isExistItem(item))
			listItem.add(item);
	}

	public void editItem(Item item) {
		if (item != null) {
			Item temp = listItem.get(listItem.indexOf(item));
			if (temp != null) {
				temp.setNumbers(item.getNumbers());
			}
		}
	}

	public boolean isExistItem(Item item) {
		return listItem.contains(item);
	}

	public ArrayList<Item> getListItem() {
		return listItem;
	}

	public void setListItem(ArrayList<Item> listItem) {
		this.listItem = listItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSumItem() {
		return listItem.size();
	}

	public int getSumQuantity() {
		int quantity = 0;
		for (Item item : listItem) {
			quantity += item.getNumbers();
		}
		return quantity;
	}

	public double getTotal() {
		double total = 0;
		for (Item item : listItem) {
			total += item.getProducts().getPrice();
		}
		return total;
	}
}
