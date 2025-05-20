package com.learn.dao;

import com.learn.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDao {
    @Autowired
    private OrderRepository orderRepository;
}
