package com.bandlogs.supermarketstore.repository;

import com.bandlogs.supermarketstore.domain.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 14:30
 * ⚡ '' - Supermarket Store
 */
@Repository
public interface VendorsRepository extends JpaRepository<Vendors, Integer> {
    boolean existsByName(String name);

}
