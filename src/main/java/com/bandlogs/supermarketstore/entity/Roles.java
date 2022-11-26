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
 * Time: 17:00
 * ⚡  - Supermarket Store
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Roles {
    @Id
    public int id;
    private String name;
    private String description;


}
