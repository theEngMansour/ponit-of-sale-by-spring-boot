package com.learn.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "total_price")
    private Double totalPrice;

}
