package com.stockmanagement.models;

import com.stockmanagement.entities.Category;
import com.stockmanagement.entities.Product;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3186274647110301377L;
    private UUID uuid;
    private String name;
    private Set<Product> products;
    private Category parent;
    private Set<Category> subCategories;
}
