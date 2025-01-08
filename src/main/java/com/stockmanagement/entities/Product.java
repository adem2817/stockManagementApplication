package com.stockmanagement.entities;

import com.stockmanagement.models.ProductDTO;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "Product")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Type(type="uuid-char")
    @Column(nullable = false, updatable = false)
    private UUID uuid;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stockCount;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Version
    private Integer version;

    public Product toProduct(ProductDTO productDTO, Category category) {
        this.uuid = UUID.randomUUID();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.stockCount = productDTO.getStockCount();
        this.category = category;
        return this;
    }
}
