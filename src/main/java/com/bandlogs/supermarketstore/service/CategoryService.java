package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Category;
import com.bandlogs.supermarketstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created with love by mundiaem
 * created on 27/11/2022
 * Time: 21:43
 * ⚡  - Supermarket Store
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Category addCategory(Category category) {

        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
