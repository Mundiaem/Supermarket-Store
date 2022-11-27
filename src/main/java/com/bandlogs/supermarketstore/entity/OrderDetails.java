package com.bandlogs.supermarketstore.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
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
public class OrderDetails {
    @Id
    public int id;
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
