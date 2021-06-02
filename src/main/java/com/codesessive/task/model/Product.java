package com.codesessive.task.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity // This tells Hibernate to make a table out of this class
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private Integer price;
    private Integer stockCount;
    private String name;
    private Integer categoryId;
    private Integer subCategoryId;
}
