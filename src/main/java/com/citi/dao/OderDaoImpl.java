package com.citi.dao;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.citi.entity.Order;

@Component
public class OderDaoImpl implements OrderDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Order> getAllOrders() {
		
		List<Map<String,Object>> orderListFromDB = jdbcTemplate.queryForList(
				"SELECT * FROM ORDER_MASTER");
		List<Order> orders = new ArrayList<Order>();
		
		for(Map<String, Object> row: orderListFromDB) {
			Order order = 
				new Order((Integer)row.get("id"), (String)row.get("name"), (Double)row.get("price"), 
						(Integer)row.get("qty"));
			orders.add(order);
		}
		return orders;
	}
	
	public List<Order> getOrderById(String OrderID) {
		List<Map<String,Object>> orderListFromDB = jdbcTemplate.queryForList(
				"SELECT * FROM ORDER_MASTER WHERE ID="+OrderID+";");
		List<Order> orders = new ArrayList<Order>();
		for(Map<String, Object> row: orderListFromDB) {
			Order order = 
				new Order((Integer)row.get("id"), (String)row.get("name"), (Double)row.get("price"), 
						(Integer)row.get("qty"));
			orders.add(order);
		}
		return orders;
	}
	
	public Order createNewOrder(Order order) {
		
		jdbcTemplate.update("INSERT INTO ORDER_MASTER VALUES(?,?,?,?);",
				order.getId(),order.getName(),order.getPrice(),order.getQty());
		return order;
	}

}
