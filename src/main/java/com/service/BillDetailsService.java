package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BillingDetails;
import com.repository.BillDetailsRepository;




@Service
public class BillDetailsService {

	@Autowired
	BillDetailsRepository bill;
	
	public  void addBillDetails(BillingDetails billingDetails) {
		bill.save(billingDetails);
	}

	public List<BillingDetails> getAllOrders() {
		// TODO Auto-generated method stub
		return bill.findAll();
	}
}

