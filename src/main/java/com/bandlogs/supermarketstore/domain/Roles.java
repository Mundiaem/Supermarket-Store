package com.bandlogs.supermarketstore.domain;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
    private String name;
    private String description;


}
