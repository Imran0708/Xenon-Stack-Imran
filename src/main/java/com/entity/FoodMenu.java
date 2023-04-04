package com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name = "food_menu")
public class FoodMenu {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodId;
	
	
	private String foodName;
	private int price;
	private String status;
	private String fooddescription;
	private Integer restaurantId; //restaurant_id
	
	
	
	public FoodMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public FoodMenu(String foodName, int price, String status, String fooddescription, Integer restaurantId) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.status = status;
		this.fooddescription = fooddescription;
		this.restaurantId = restaurantId;
	}



	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFooddescription() {
		return fooddescription;
	}
	public void setFooddescription(String fooddescription) {
		this.fooddescription = fooddescription;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}



	@Override
	public String toString() {
		return "FoodMenu [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", status=" + status
				+ ", fooddescription=" + fooddescription + ", restaurantId=" + restaurantId + "]";
	}
	
	
	
	


}
