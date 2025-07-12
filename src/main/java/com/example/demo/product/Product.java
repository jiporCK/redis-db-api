package com.example.demo.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private Integer qty;

    private LocalDateTime createdAt;

    public Product(String name, BigDecimal price, Integer qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.createdAt = LocalDateTime.now();
    }

}
