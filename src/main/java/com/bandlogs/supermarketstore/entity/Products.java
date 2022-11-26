package com.bandlogs.supermarketstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 19:51
 * ⚡  - Supermarket Store
 *
 * Id
 * Name
 * Description
 * Unit
 * Price
 * Quantity
 * Status
 * Other_details
 * Vendor_id
 * Category_id
 * Mf_date
 * Exp_date
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Products {
    @Id
    public int id;
    private String name;
    private String description;
    private String unit;
    private float price;
    private int quantity;
    private String status;
    private String other_details;
    private int vendor_id;
    private int category_id;
    private Date mf_date;
    private Date exp_date;
}
