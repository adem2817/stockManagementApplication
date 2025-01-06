package com.stockmanagement.repositories;

import com.stockmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
    List<Product> findAll();
    List<Product> findByPriceBetween(Integer min, Integer max);
    List<Product> findByName(String name);
}
