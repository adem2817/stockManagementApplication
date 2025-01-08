package com.stockmanagement.repositories;

import com.stockmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
    Optional<Product> findByUuid(UUID id);
    List<Product> findAll();
    @Query("SELECT p FROM Product p WHERE " +
            "(:name IS NULL OR p.name = :name) AND " +
            "(:categoryName IS NULL OR p.category.name = :categoryName) AND " +
            "(:min IS NULL OR p.price >= :min) AND " +
            "(:max IS NULL OR p.price <= :max)")
    List<Product> findByNameAndCategory_NameAndPriceBetween(@Param("name") String name,
                                                            @Param("categoryName") String categoryName,
                                                            @Param("min") BigDecimal min,
                                                            @Param("max") BigDecimal max);
    List<Product> findByName(String name);
}
