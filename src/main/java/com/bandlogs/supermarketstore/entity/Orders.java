package com.bandlogs.supermarketstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 20:18
 * ⚡  - Supermarket Store
 *
 * Id
 * Date_of_order
 * Order_details
 * vendor_id
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    public int id;
    private Date date_of_order;
    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetails;




}
