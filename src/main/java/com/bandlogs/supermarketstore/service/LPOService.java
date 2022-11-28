package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.LPO;
import com.bandlogs.supermarketstore.repository.LPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 18:05
 * ⚡  - Supermarket Store
 */
@Service
public class LPOService {
    @Autowired
    private LPORepository orderRepository;

    public LPO saveOrder(LPO order) {
        return orderRepository.save(order);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    public List<LPO> findALlOrders() {
        return orderRepository.findAll();
    }

}
