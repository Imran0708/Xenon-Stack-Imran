package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ordernum")
	private int orderNum;
	
	 private double amount;

	 private String customerName;
	 
	 private String customerAddress;
	 
	 private String customerEmail;
	 
	 private String customerPhone;
	 

	 
	 private String orderStatus;

	 





	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public int getOrderNum() {
		return orderNum;
	}




	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getCustomerName() {
		return customerName;
	}




	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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




	public String getCustomerPhone() {
		return customerPhone;
	}




	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}




	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getOrderStatus() {
		return orderStatus;
	}




	public Orders(Long id, int orderNum, double amount, String customerName, String customerAddress,
			String customerEmail, String customerPhone, String orderStatus) {
		super();
		this.id = id;
		this.orderNum = orderNum;
		this.amount = amount;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.orderStatus = orderStatus;
	}




	public Orders(int orderNum, double amount, String customerName, String customerAddress, String customerEmail,
			String customerPhone, String orderStatus) {
		super();
		this.orderNum = orderNum;
		this.amount = amount;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.orderStatus = orderStatus;
	}




	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNum=" + orderNum + ", amount=" + amount + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + ", customerEmail=" + customerEmail + ", customerPhone="
				+ customerPhone + ", orderStatus=" + orderStatus + "]";
	}



	 
	 
	 
}
