package com.bandlogs.supermarketstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 21:45
 * ⚡  - Supermarket Store
 * Id
 * Name
 * description
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
@Builder
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(targetEntity = Products.class, mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Products> products= new ArrayList<Products>();;
    private String name;
    private String Description;


}
