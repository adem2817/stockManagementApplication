package com.codesessive.task.service;

import com.codesessive.task.model.Category;
import com.codesessive.task.model.Product;
import com.codesessive.task.model.SubCategory;
import com.codesessive.task.repository.CategoryRepository;
import com.codesessive.task.repository.ProductRepository;
import com.codesessive.task.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockManagementService implements IStockManagementService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Boolean sellProduct(int id, int stockCount) {
        return productRepository.sellProduct(id, stockCount) > 0 ? true : false;
    }

    @Override
    public List<Product> findByPriceInterval(int min, int max) {
        return productRepository.findByPriceInterval(min, max);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
