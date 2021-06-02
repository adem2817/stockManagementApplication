package com.codesessive.task.service;

import com.codesessive.task.model.Category;
import com.codesessive.task.model.Product;
import com.codesessive.task.model.SubCategory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface IStockManagementService {

    Category addCategory(Category category);
    SubCategory addSubCategory(SubCategory subCategory);
    Product addProduct(Product product);

    Boolean sellProduct(int id, int stockCount);
    List<Product> findByPriceInterval(int min, int max);
    List<Product> findByName(String name);
}
