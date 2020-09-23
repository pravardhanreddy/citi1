package com.citi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.dao.OrderDao;
import com.citi.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	public List<Order> getAllOrders() {
		
		return orderDao.getAllOrders();
	}
	
	public List<Order> getOrderById(String OrderID) {
		return orderDao.getOrderById(OrderID);
	}
	
	public Order createNewOrder(Order order) {
		return orderDao.createNewOrder(order);
	}

}
