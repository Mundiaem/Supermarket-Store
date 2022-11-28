package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Receive;
import com.bandlogs.supermarketstore.repository.ReceiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 15:56
 * ⚡  - Supermarket Store
 */
@Service
public class ReceiveService {
    @Autowired
    private ReceiveRepository receiveRepository;

    public Receive saveReceive(Receive Receive) {
        return receiveRepository.save(Receive);
    }

    public void deleteAll() {
        receiveRepository.deleteAll();
    }

    public List<Receive> findALlReceives() {
        return receiveRepository.findAll();
    }
}
