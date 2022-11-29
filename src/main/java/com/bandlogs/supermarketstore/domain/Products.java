package com.bandlogs.supermarketstore.domain;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    private String description;
    @Column(name = "unit_price")
    private int unit;
    @Column(name = "total_price")
    private double price;
    private int quantity;
    private String status;
    private String other_details;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prod_vendor_id")
    private Vendors vendor;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="prod_category_id", nullable=false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prod_release_id")
    private Release release;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prod_receive_id")
    private Receive receive;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prod_return_id")
    private Returns returns;
    private Date mf_date;
    private Date exp_date;



    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", price=" + price +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", other_details='" + other_details + '\'' +
                ", mf_date=" + mf_date +
                ", exp_date=" + exp_date +
                '}';
    }
}
