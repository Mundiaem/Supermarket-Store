package com.bandlogs.supermarketstore.repository;

import com.bandlogs.supermarketstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created with love by mundiaem
 * created on 27/11/2022
 * Time: 21:10
 * ⚡ '' - Supermarket Store
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
