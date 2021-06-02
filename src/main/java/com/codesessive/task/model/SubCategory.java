package com.codesessive.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity // This tells Hibernate to make a table out of this class
public class SubCategory {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    private String name;
    private Integer categoryId;
}
