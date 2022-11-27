package com.bandlogs.supermarketstore.entity;

/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 21:45
 * ⚡  - Supermarket Store
 * Bill_number
 * Payment_type
 * Other_details
 */
import javax.persistence.*;
@Entity
public class Payments {
    public Long bill_number;
    private String payment_type;
    private String other_details;
}
