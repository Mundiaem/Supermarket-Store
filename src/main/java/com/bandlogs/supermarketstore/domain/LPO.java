package com.bandlogs.supermarketstore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created with love by mundiaem
 * created on 26/11/2022
 * Time: 20:18
 * ⚡  - Supermarket Store
 * <p>
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
@Builder
public class LPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
    @OneToMany(targetEntity = OrderDetails.class, mappedBy = "lpo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
    @Column(name = "lpo_issue_date")
    private Date lpo_issue_date;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_vendor_id", nullable = false)
    private Vendors vendor;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payments payment;
    ;


}
