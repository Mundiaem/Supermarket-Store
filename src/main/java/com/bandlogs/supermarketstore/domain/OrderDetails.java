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
    private float unit_price;
    private int size;
    private int quantity;
    private float discount;
    private int total;
    private Date date;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Products product;
    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Orders  order;
    @ManyToOne
    @JoinColumn(name="payment_id", nullable=false)
    private Payments payment;

}
