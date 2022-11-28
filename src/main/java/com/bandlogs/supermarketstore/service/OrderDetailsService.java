package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.LPO;
import com.bandlogs.supermarketstore.domain.OrderDetails;
import com.bandlogs.supermarketstore.repository.LPORepository;
import com.bandlogs.supermarketstore.repository.OrderDetailsRepository;
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
    private OrderDetailsRepository orderDetailsRepository;

    public OrderDetails saveOrder(OrderDetails orderDetail) {
        return orderDetailsRepository.save(orderDetail);
    }

    public void deleteAll() {
        orderDetailsRepository.deleteAll();
    }

    public List<OrderDetails> findALlOrders() {
        return orderDetailsRepository.findAll();
    }
}


