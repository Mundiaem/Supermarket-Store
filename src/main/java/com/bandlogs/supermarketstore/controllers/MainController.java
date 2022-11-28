package com.bandlogs.supermarketstore.controllers;

import com.bandlogs.supermarketstore.domain.Category;
import com.bandlogs.supermarketstore.domain.LPO;
import com.bandlogs.supermarketstore.domain.Products;
import com.bandlogs.supermarketstore.service.CategoryService;
import com.bandlogs.supermarketstore.service.LPOService;
import com.bandlogs.supermarketstore.service.ProductServices;
import com.bandlogs.supermarketstore.util.CustomErrorType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/**
 * created with love by mundiaem
 * created on 27/11/2022
 * Time: 21:46
 * https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting
 * ⚡  - Supermarket Store
 */
@RestController
@Slf4j
@RequestMapping("/store")

public class MainController {
    public static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private static final String TAG = MainController.class.getSimpleName().toString();
    @Autowired
    LPOService lpoService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductServices productServices;

    @PostMapping(value = "/add_category/", consumes = {"application/json"})
    public ResponseEntity<?> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {

        if (categoryService.existByName(category.getName())) {
            logger.error("Unable to create. A Category with name {} already exist", category.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Category with name " +
                    category.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        categoryService.addCategory(category);
        System.out.printf("******* Save Category @ %s and User is  %s%n", TAG, "-------");
        log.info(String.format("******* Save Category @ %s and LPO is  %s", TAG, category.toString()));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/store/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);


    }

    @GetMapping("/category/{id}/")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") int id) {
        logger.info("Updating Category with id {}", id);

        Optional<Category> category = categoryService.findCategoryById(id);

        if (!category.isPresent()) {
            logger.error("Unable to Get. Category with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Category>>(category, HttpStatus.OK);
    }

    @GetMapping("/categories/")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @PostMapping("/add-products")
    public Products createProducts(@RequestBody Products products) {
        System.out.printf("******* Save User @ %s and User is  %s%n", TAG, "-------");
        log.info(String.format("******* Save LPO @ %s and LPO is  %s", TAG, products.toString()));
        return productServices.addProduct(products);
    }

    @PostMapping("/")
    public LPO raiseIPO(@RequestBody LPO lpo) {
        System.out.printf("******* Save User @ %s and User is  %s%n", TAG, "-------");
        log.info(String.format("******* Save LPO @ %s and LPO is  %s", TAG, lpo.toString()));
        return lpoService.saveOrder(lpo);
    }
}
