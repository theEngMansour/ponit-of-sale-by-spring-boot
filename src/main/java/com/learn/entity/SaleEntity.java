package com.learn.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sales")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "sale_id")
    private Integer saleId;


    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "order_id")
    private Integer orderId;
}
