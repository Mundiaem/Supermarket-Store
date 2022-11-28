package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Orders;
import com.bandlogs.supermarketstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 15:20
 * ⚡  - Supermarket Store
 */
@Service
public class OrderDetailsService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public List<Orders> findALlOrders() {
        return orderRepository.findAll();
    }
}


