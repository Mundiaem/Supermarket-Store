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
 * Time: 19:52
 * ⚡  - Supermarket Store
 * Id
 * Name
 * Address
 * Phone
 * Email
 * Other_details
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendor")
@Builder
public class Vendors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String other_details;
    @OneToMany(targetEntity = Products.class, mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Products> products= new ArrayList<Products>();
    @OneToMany(targetEntity = LPO.class, mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<LPO> orders= new ArrayList<LPO>();



}
