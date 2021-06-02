package com.codesessive.task.repository;

import com.codesessive.task.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    SubCategory findById(int id);
    SubCategory save(SubCategory subCategory);
    List<SubCategory> findAll();

}
