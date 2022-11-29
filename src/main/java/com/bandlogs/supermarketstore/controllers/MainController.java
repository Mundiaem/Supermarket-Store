package com.bandlogs.supermarketstore.controllers;

import com.bandlogs.supermarketstore.domain.Category;
import com.bandlogs.supermarketstore.domain.LPO;
import com.bandlogs.supermarketstore.service.CategoryService;
import com.bandlogs.supermarketstore.service.LPOService;
import com.bandlogs.supermarketstore.service.ProductServices;
import com.bandlogs.supermarketstore.util.CustomErrorType;
import lombok.extern.slf4j.Slf4j;
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
 * created on 27/11/2022
 * Time: 21:46
 * https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting
 * ⚡  - Supermarket Store
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/category")
public class MainController {
    public static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private static final String TAG = MainController.class.getSimpleName().toString();
    @Autowired
    LPOService lpoService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductServices productServices;

    @PostMapping(value = "/", consumes = {"application/json"})
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {

        if (categoryService.existByName(category.getName())) {
            logger.error("Unable to create. A Category with name {} already exist", category.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Category with name " +
                    category.getName() + " already exist."), HttpStatus.CONFLICT);
        }
        Category optionalCategory = categoryService.addCategory(category);

        return new ResponseEntity<>(optionalCategory, HttpStatus.CREATED);


    }

    @GetMapping({"/"})
    public ResponseEntity<Category> getCategoryById(@RequestParam("id") Integer id) {
        logger.info("getting  Category by id {}", 1552);
        Optional<Category> category = categoryService.findCategoryById(id);
        if (!category.isPresent()) {
            logger.error("Unable to Get. Category with id {} not found.", 1552);
            return new ResponseEntity(new CustomErrorType("Unable to get. category with id " + 1552 + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }


    @PostMapping("/")
    public LPO raiseIPO(@RequestBody LPO lpo) {
        System.out.printf("******* Save User @ %s and User is  %s%n", TAG, "-------");
        log.info(String.format("******* Save LPO @ %s and LPO is  %s", TAG, lpo.toString()));
        return lpoService.saveOrder(lpo);
    }
}
