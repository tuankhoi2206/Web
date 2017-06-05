package model;

public class Customer {

	private String customerAddress;
	private String customerEmail;
	private String customerName;
	private String customerPhone;

	public Customer() {
	}

	public Customer(String customerAddress, String customerEmail,
			String customerName, String customerPhone) {
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

}
