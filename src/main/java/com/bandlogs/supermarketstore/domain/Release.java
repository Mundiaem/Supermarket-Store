package com.bandlogs.supermarketstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
