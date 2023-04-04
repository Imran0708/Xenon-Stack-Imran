package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Orders;

import com.repository.OrderDetailsRepository;

@Service
public class OrderDetailsImpl implements OrderDetailsService {
@Autowired
	OrderDetailsRepository detailsRepository;

@Override
public List<Orders> getallOrders() {
	// TODO Auto-generated method stub
	return detailsRepository.findAll();
}
	


}