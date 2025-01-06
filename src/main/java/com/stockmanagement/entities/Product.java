package com.stockmanagement.entities;

import lombok.*;

import javax.persistence.*;


@Data
@Entity(name = "Product")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer price;
    private Integer stockCount;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Version
    private Integer version;
}
