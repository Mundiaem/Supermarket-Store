package com.bandlogs.supermarketstore.controllers;


import com.bandlogs.supermarketstore.domain.Users;
import com.bandlogs.supermarketstore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created with love by mundiaem
 * created on 28/07/2021
 * Time: 13:12
 * ⚡  - UserServiece
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final static String TAG= UserController.class.getName();
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user) {
        System.out.printf("******* Save User @ %s and User is  %s%n", TAG, "-------");
        log.info(String.format("******* Save User @ %s and User is  %s", TAG, user.toString()));
        return userService.save(user);
    }



}
