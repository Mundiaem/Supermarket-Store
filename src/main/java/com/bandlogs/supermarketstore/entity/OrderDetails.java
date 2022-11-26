package com.bandlogs.supermarketstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
