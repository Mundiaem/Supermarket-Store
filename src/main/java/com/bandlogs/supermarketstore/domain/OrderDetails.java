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
 * Time: 20:49
 * ⚡  - Supermarket Store
 * Id
 * Unit_price
 * Size
 * Quantity
 * Discount
 * Total
 * Date
 * Product_id
 * Order_id
 * Bill_number
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
@Builder
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
    @Column(name = "unit_price")
    private double unit_price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private double discount;
    @Column(name = "total_price")
    private double total;
    @Column(name = "order_date")
    private Date order_date;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private LPO lpo;


}
