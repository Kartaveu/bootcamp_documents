package com.capgemini.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.bookstore.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{

}