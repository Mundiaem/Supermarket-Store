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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Returns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
}
