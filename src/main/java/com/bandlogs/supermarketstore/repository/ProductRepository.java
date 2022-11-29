package com.bandlogs.supermarketstore.repository;

import com.bandlogs.supermarketstore.domain.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * created with love by mundiaem
 * created on 27/11/2022
 * Time: 21:09
 * ⚡  - Supermarket Store
 */
@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
    boolean existsByName(String name);
}
