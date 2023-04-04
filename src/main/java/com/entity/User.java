package com.entity;


	import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name = "user")
	public class User {
		
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int userId;
		
		@Column(name = "first_name")
		private String firstName;
		
		@Column(name = "last_name")
		private String lastName;
		
		@Column(length = 50,unique = true,nullable =false)
		private String email;
		
		@Column(length = 10, name = "phone_number", unique = true)
		private long mobileNo;
		
		@Column(name = "gender")
		private String gender;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "city")
		private String city;
		
		
	 	@Column(name = "state")
		private String state;
		
		@Column(name = "pin_code")
		private int pinCode;
		
		@Column(name = "password")
		private String password;
		
		@DateTimeFormat(pattern = "DD-MM-YYYY")
		@Column(name = "date")
		private Date date;
		
		@Column(name = "role")
		private String role;
		
		
		
		/*
		 * private boolean extra1; private String extra2; private String extra3;
		 */
		
		public User() {
			super();
			
		}
		
		public User(int userId, String firstName, String lastName, String email, long mobileNo, String gender,
				String address, String city, String state, int pinCode, String password, Date date, String role) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobileNo = mobileNo;
			this.gender = gender;
			this.address = address;
			this.city = city;
			this.state = state;
			this.pinCode = pinCode;
			this.password = password;
			this.date = date;
			this.role = role;
		
		}
		


		public User(String firstName, String lastName, String email, long mobileNo, String gender, String address,
				String city, String state, int pinCode, String password, Date date, String role) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobileNo = mobileNo;
			this.gender = gender;
			this.address = address;
			this.city = city;
			this.state = state;
			this.pinCode = pinCode;
			this.password = password;
			this.date = date;
			this.role = role;
			
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public int getPinCode() {
			return pinCode;
		}

		public void setPinCode(int pinCode) {
			this.pinCode = pinCode;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Restaurant getRestaurant() {
			return restaurant;
		}

		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}

	
		

		
		
		



		@Override
		public String toString() {
			return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", mobileNo=" + mobileNo + ", gender=" + gender + ", address=" + address + ", city=" + city
					+ ", state=" + state + ", pinCode=" + pinCode + ", password=" + password + ", date=" + date + ", role="
					+ role + ", restaurant=" + restaurant  + "]";
		}









		@OneToOne(cascade=CascadeType.ALL,mappedBy="user")
		private Restaurant restaurant;
		
	
		
		
		
	}


