package com.codesessive.task.repository;

import com.codesessive.task.model.Category;
import com.codesessive.task.model.Product;
import com.codesessive.task.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);
    Category save(Category category);
    List<Category> findAll();
}
