package com.bandlogs.supermarketstore.service;

import com.bandlogs.supermarketstore.domain.Users;
import com.bandlogs.supermarketstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 14:05
 * ⚡  - Supermarket Store
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users save(Users users){
       return userRepository.save(users);
    }
}
