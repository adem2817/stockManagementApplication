package com.stockmanagement.entities;

import com.stockmanagement.models.CategoryDTO;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name = "Category")
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Type(type="uuid-char")
    @Column(nullable = false, updatable = false)
    private UUID uuid;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Category> subCategories = new HashSet<>();

    public Category toCategory(CategoryDTO categoryDTO) {
        this.uuid = UUID.randomUUID();
        this.name = categoryDTO.getName();
        return this;
    }

    public Category toSubCategory(CategoryDTO categoryDTO, Category parent) {
        this.uuid = UUID.randomUUID();
        this.name = categoryDTO.getName();
        this.parent = parent;
        return this;
    }
}
