package com.citi.controller;

import com.citi.entity.*;
import com.citi.service.OrderService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

//	@GetMapping(value="/order/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public Order getOrderById(@PathVariable("id") String orderID) {
//		return new Order(Integer.parseInt(orderID),"Computer", new Item("part"));
//	}
//	
//	@GetMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<Order> getAllOrders() {
//		List<Order> o = new ArrayList<Order>();
//		o.add(new Order(3, "GPU", new Item("computer")));
//		o.add(new Order(4, "CPU", new Item("computer")));
//		return o;
//	}
	
	@GetMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping(value="/order/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getOrderById(@PathVariable("id") String orderID) {
		return orderService.getOrderById(orderID);
	}
	
	@PostMapping(value="/order", produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Order createNewOrder(@RequestBody Order order) {
		return orderService.createNewOrder(order);
	}
}
