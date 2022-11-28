package com.bandlogs.supermarketstore.domain;

/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 21:46
 * ⚡  - Supermarket Store
 * Id
 * Date
 * Description
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Returns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private Date return_date;
    private String description;
    @OneToMany(targetEntity = Products.class, mappedBy = "returns", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Products> products= new ArrayList<>();
}
