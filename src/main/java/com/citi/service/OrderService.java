package com.citi.service;

import java.util.List;

import com.citi.entity.Order;

public interface OrderService {
	public List<Order> getAllOrders();
	public List<Order> getOrderById(String orderID);
	public Order createNewOrder(Order order);
}
