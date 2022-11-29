package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Products;
import com.bandlogs.supermarketstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created with love by mundiaem
 * created on 27/11/2022
 * Time: 21:42
 * ⚡  - Supermarket Store
 */
@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public Products addProduct(Products products) {

        return productRepository.save(products);
    }

    public Iterable<Products> findAll() {
        return productRepository.findAll();
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
    public boolean productExists(String name){
        return productRepository.existsByName(name);
    }


}
