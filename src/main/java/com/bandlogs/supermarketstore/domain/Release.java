package com.bandlogs.supermarketstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 28/11/2022
 * Time: 18:22
 * ⚡  - Supermarket Store
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "release")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private Date release_date;
    private String description;
    @OneToMany(targetEntity = Products.class, mappedBy = "release", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Products> products= new ArrayList<>();
}
