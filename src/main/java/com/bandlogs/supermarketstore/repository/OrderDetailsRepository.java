package com.bandlogs.supermarketstore.repository;

import com.bandlogs.supermarketstore.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 21:40
 * ⚡  - Supermarket Store
 */

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
