package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	
	@Column(name = "restaurant_name")
	 private  String restaurantName;
	
	@Column(length = 50,unique = true,nullable =false)
	 private String licenseNo;
	
	@Column(name = "cateogry")
	 private String cateogry;
	
	@Column(name = "restaurantType")
	 private String restaurantType;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	 private String restaurantImage;
	
	
		/*
		 * private String extra1; private String extra2; private String extra3; private
		 * boolean extra4;
		 */
	
	@OneToOne(cascade=CascadeType.ALL )
	@JoinColumn(name="id")
	private User user;

	 
	 
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Restaurant(int restaurantId, String restaurantName, String licenseNo, String cateogry, String restaurantType,
			String restaurantImage) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.licenseNo = licenseNo;
		this.cateogry = cateogry;
		this.restaurantType = restaurantType;
		this.restaurantImage = restaurantImage;
	}

	
	
	

	public Restaurant(String restaurantName, String licenseNo, String cateogry, String restaurantType,
			String restaurantImage) {
		super();
		this.restaurantName = restaurantName;
		this.licenseNo = licenseNo;
		this.cateogry = cateogry;
		this.restaurantType = restaurantType;
		this.restaurantImage = restaurantImage;
		
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getLicenseNo() {
		return licenseNo;
	}


	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}


	public String getCateogry() {
		return cateogry;
	}


	public void setCateogry(String cateogry) {
		this.cateogry = cateogry;
	}


	public String getRestaurantType() {
		return restaurantType;
	}


	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}


	public String getRestaurantImage() {
		return restaurantImage;
	}


	public void setRestaurantImage(String restaurantImage) {
		this.restaurantImage = restaurantImage;
	}


	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", licenseNo="
				+ licenseNo + ", cateogry=" + cateogry + ", restaurantType=" + restaurantType + ", restaurantImage="
				+ restaurantImage + "]";
	}
	
	
	 
	 
	 
}