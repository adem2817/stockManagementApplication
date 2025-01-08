package com.stockmanagement.models;

import com.stockmanagement.entities.Category;
import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8895734029753430721L;
    private UUID uuid;
    @Min(value = 0, message = "Price must be greater than 0")
    private BigDecimal price;
    @Min(value = 0, message = "Stock count must be greater than 0")
    private Integer stockCount;
    private String name;
    private UUID category;
}
