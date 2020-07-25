package com.capgemini.bookstore.service;

import com.capgemini.bookstore.entity.Order;

import java.util.List;

public interface OrderService {

		boolean submitOrder(Order order);

	    List<Order> showallorder();

}


