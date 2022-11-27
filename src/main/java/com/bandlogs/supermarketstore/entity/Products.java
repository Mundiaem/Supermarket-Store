package com.bandlogs.supermarketstore.entity;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="vendor_id", nullable=false)
    private Vendors vendors;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
    private Date mf_date;
    private Date exp_date;
}
