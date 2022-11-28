package com.bandlogs.supermarketstore;

import com.bandlogs.supermarketstore.repository.CategoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan(basePackages = {"com.bandlogs.supermarketstore.*", "com.bandlogs.supermarketstore.config"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.bandlogs.supermarketstore.*", "com.bandlogs.supermarketstore.config"})
@EntityScan(basePackages = {"com.bandlogs.supermarketstore.domain"})
@EnableJpaRepositories(basePackages = "com.bandlogs.supermarketstore.repository", entityManagerFactoryRef = "entityManagerFactory")
public class SupermarketStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarketStoreApplication.class, args);
    }

}
