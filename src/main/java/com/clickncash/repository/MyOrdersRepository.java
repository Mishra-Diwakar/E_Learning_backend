package com.clickncash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clickncash.entity.MyOrders;

public interface MyOrdersRepository extends JpaRepository<MyOrders, Long>{

}
