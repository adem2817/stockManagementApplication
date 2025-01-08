package com.stockmanagement.services;

import com.stockmanagement.entities.Product;
import com.stockmanagement.models.SearchProductDTO;
import com.stockmanagement.models.SellProductDTO;
import com.stockmanagement.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private static final String ERROR_WHILE_SAVING_PRODUCT = "Error while saving product:";

    @Transactional
    public Product save(Product product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            log.error(ERROR_WHILE_SAVING_PRODUCT, e);
            throw new RuntimeException(ERROR_WHILE_SAVING_PRODUCT, e.getCause());
        }
        return product;
    }

    public List<Product> search(SearchProductDTO searchProductDTO) {
        return productRepository.findByNameAndCategory_NameAndPriceBetween(searchProductDTO.getName(),
                searchProductDTO.getCategoryName(), searchProductDTO.getMinPrice(), searchProductDTO.getMaxPrice());
    }

    public void sellProduct(SellProductDTO sellProductDTO) {
        Product product = productRepository.findByUuid(sellProductDTO.getProductUuid()).orElseThrow(() -> new RuntimeException("Product not found"));
        int remainingStock = product.getStockCount() - sellProductDTO.getQuantity();
        if (remainingStock < 0) {
            throw new RuntimeException("Not enough stock");
        } else {
            product.setStockCount(remainingStock);
        }
        productRepository.save(product);
    }
}
