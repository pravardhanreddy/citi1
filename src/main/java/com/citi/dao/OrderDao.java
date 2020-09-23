package com.citi.dao;

import java.util.List;

import com.citi.entity.Order;

public interface OrderDao {
	List<Order> getAllOrders();
	List<Order> getOrderById(String OrderID);
	Order createNewOrder(Order order);
}
