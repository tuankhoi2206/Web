package entity;

// Generated Sep 18, 2016 11:09:46 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders", catalog = "shoppingdb", uniqueConstraints = @UniqueConstraint(columnNames = "Order_Num"))
public class Orders implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private double amount;
	private String customerAddress;
	private String customerEmail;
	private String customerName;
	private String customerPhone;
	private Date orderDate;
	private int orderNum;
	private Set<OrderDetails> orderDetailses = new HashSet<OrderDetails>(0);

	public Orders() {
		this("", 0d, "", "", "", "", null, 0);
	}

	public Orders(String id, double amount, String customerAddress,
			String customerEmail, String customerName, String customerPhone,
			Date orderDate, int orderNum) {
		this.id = id;
		this.amount = amount;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.orderDate = orderDate;
		this.orderNum = orderNum;
	}

	public Orders(String id, double amount, String customerAddress,
			String customerEmail, String customerName, String customerPhone,
			Date orderDate, int orderNum, Set<OrderDetails> orderDetailses) {
		this.id = id;
		this.amount = amount;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.orderDetailses = orderDetailses;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "Amount", nullable = false, precision = 22, scale = 0)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "Customer_Address", nullable = false)
	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Column(name = "Customer_Email", nullable = false, length = 128)
	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Column(name = "Customer_Name", nullable = false)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "Customer_Phone", nullable = false, length = 128)
	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Order_Date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "Order_Num", unique = true, nullable = false)
	public int getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<OrderDetails> getOrderDetailses() {
		return this.orderDetailses;
	}

	public void setOrderDetailses(Set<OrderDetails> orderDetailses) {
		this.orderDetailses = orderDetailses;
	}

}
