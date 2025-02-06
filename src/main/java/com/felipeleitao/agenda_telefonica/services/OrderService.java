package com.felipeleitao.agenda_telefonica.services;

import com.felipeleitao.agenda_telefonica.models.Order;
import com.felipeleitao.agenda_telefonica.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}