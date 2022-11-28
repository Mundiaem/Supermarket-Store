package com.bandlogs.supermarketstore.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 21:45
 * ⚡  - Supermarket Store
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Supermarket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
}
