package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.FoodMenu;
@Repository
public interface MenuRepository extends JpaRepository<FoodMenu, Integer> {

	@Query(value ="select food_id,food_name,fooddescription,price,status,restaurant_id from food_menu where restaurant_id= ?1 and status='available'" , nativeQuery =true)
	 public List<FoodMenu> GetMenuById(int id);

	
	@Query(value="select food_id,food_name,fooddescription,price,status,restaurant_id from food_menu where food_id= ?1",nativeQuery =true)  
	 public FoodMenu getCartMenuById(int id);

}
