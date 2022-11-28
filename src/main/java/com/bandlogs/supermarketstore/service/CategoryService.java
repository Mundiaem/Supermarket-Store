package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Category;
import com.bandlogs.supermarketstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    public boolean existByName(String name){
        return categoryRepository.existsByName(name);
    }
    public Optional<Category> findCategoryById(int id){
        return categoryRepository.findById(id);
    }
}
