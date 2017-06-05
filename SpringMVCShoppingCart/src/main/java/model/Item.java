package model;

import entity.Products;

public class Item {

	private Products products;
	private int numbers;

	public Item() {
		products = new Products();
		numbers = 0;
	}

	public Item(Products products) {
		this.numbers = 1;
		this.setProducts(products);
	}

	public void addNumbers(int numbers) throws Exception {
		if (numbers < 0)
			throw new Exception(" input valid numbers");
		numbers += numbers;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

}
