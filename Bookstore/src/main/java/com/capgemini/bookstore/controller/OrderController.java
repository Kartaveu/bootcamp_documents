package com.capgemini.bookstore.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookstore.entity.Order;
import com.capgemini.bookstore.exception.OrderException;
import com.capgemini.bookstore.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@PostMapping("/submitorder")
	public ResponseEntity<String> submitOrder(@Valid @RequestBody Order order, BindingResult br)throws OrderException{
		String err = "";
		if(br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new OrderException(err);
		}
		try {
			orderService.submitOrder(order);
			return new ResponseEntity<String>("Order Submitted Successfully", HttpStatus.OK);
		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("Already Exists");
		}
	}
	
	@CrossOrigin
	@GetMapping("/viewallorder")
	public ResponseEntity<List<Order>> getallorder() {
		List<Order> orderList = orderService.showallorder();
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}


	}
	
	
