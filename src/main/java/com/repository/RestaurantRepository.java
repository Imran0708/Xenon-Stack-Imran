package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	
	

	@Query(value = "select restaurant_id from restaurant where id= ?", nativeQuery =true)
	public Restaurant getRestByyUserId(int userId);
	
	
	
}
