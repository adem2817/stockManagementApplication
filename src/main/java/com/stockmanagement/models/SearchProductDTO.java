package com.stockmanagement.models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SearchProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2117164548990369364L;
    private String name;
    private String categoryName;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
