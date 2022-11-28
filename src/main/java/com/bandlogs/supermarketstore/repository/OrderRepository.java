package com.bandlogs.supermarketstore.repository;

import com.bandlogs.supermarketstore.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 14:29
 * ⚡  - Supermarket Store
 */

public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
