package com.capgemini.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookstore.dao.OrderDao;
import com.capgemini.bookstore.entity.Order;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

		@Autowired
		OrderDao orderDao;

		@Override
		public boolean submitOrder(Order order) {
			Order testresult = orderDao.save(order);
			if (testresult != null) {
				return true;
			} else
				return false;
		}

		@Override
		public List<Order> showallorder() {
			return orderDao.findAll();
		}
	}


