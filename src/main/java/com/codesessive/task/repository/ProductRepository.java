package com.codesessive.task.repository;

import com.codesessive.task.model.Product;
import com.codesessive.task.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
    Product save(SubCategory subCategory);
    List<Product> findAll();



    @Query("Select p from Product p where price between :min and :max")
    List<Product> findByPriceInterval(@Param("min") Integer min, @Param("max") Integer max);

    @Query(" Select p  " +
            " from Product p " +
            " Inner join Category c on p.categoryId = c.Id " +
            " Inner join SubCategory sc on p.subCategoryId = sc.Id " +
            " where p.name like :name " +
            "   or c.name like :name " +
            "   or sc.name like :name ")
    List<Product> findByName(@Param("name") String name);

    @Query(" update Product p set p.stockCount = p.stockCount - :count where p.stockCount - :count > 0 and p.Id = :id ")
    Integer sellProduct(@Param("id") Integer id, @Param("count") Integer count);
}
