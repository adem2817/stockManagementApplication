package com.stockmanagement.repositories;

import com.stockmanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(int id);
    List<Category> findAll();

    Optional<Category> findByUuid(UUID categoryId);
}
