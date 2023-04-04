package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Orders;

public interface OrderDetailsRepository extends JpaRepository<Orders, Long> {

}
