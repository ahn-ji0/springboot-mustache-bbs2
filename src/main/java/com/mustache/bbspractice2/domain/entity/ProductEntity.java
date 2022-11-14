package com.mustache.bbspractice2.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
