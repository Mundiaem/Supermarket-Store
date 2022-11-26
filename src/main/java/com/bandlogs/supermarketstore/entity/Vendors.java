package com.bandlogs.supermarketstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "vendors")
public class Vendors {
    @Id
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String other_details;
}
