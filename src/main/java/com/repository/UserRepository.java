package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;
public interface UserRepository extends JpaRepository<User, Integer> {

	
	
//	
//	@Query("SELECT * from products as p left join cart_items as cart on cart.product_id =p.id left \\r\\n\"\r\n"
//			+ "			+ \"join customers as cust on cart.customer_id= cust.id")
	User findByEmailAndPassword(String email, String password);

	User getUserByEmail(String email);
	
}
