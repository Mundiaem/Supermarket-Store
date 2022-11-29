package com.bandlogs.supermarketstore.controllers;

import com.bandlogs.supermarketstore.domain.Category;
import com.bandlogs.supermarketstore.domain.Products;
import com.bandlogs.supermarketstore.domain.Vendors;
import com.bandlogs.supermarketstore.service.CategoryService;
import com.bandlogs.supermarketstore.service.ProductServices;
import com.bandlogs.supermarketstore.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * created with love by mundiaem
 * created on 29/11/2022
 * Time: 11:26
 * ⚡  - Supermarket Store
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductsController {
    public static final Logger logger = LoggerFactory.getLogger(ProductsController.class);
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductServices productServices;

    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<Products> createProducts(@RequestParam("cat_id") Integer cat_id, @RequestBody Products product) {
        Optional<Category> optionalCategory = categoryService.findCategoryById(cat_id);
        if (productServices.productExists(product.getName())) {
            logger.error("Unable to create. A Category with name {} already exist", product.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Category with name " +
                    product.getName() + " already exist."), HttpStatus.CONFLICT);
        } else if (!optionalCategory.isPresent()) {
            logger.error("Unable to create. A Category with id {} does not  exist", cat_id);
            return new ResponseEntity(new CustomErrorType("Unable to create. A Product with does not  exist  " +
                    cat_id + " does not exist."), HttpStatus.CONFLICT);
        }
        product.setCategory(optionalCategory.get());
        Products product_ = productServices.addProduct(product);
        return new ResponseEntity<>(product_, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productServices.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity(new CustomErrorType("No products at the moment"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
    }
}
