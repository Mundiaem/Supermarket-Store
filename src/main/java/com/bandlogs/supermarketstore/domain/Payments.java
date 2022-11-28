package com.bandlogs.supermarketstore.domain;

/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 21:45
 * ⚡  - Supermarket Store
 * Bill_number
 * Payment_type
 * Other_details
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long bill_number;
    private String payment_type;
    private String other_details;
}
