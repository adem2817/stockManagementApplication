package com.stockmanagement.services;

import com.stockmanagement.entities.Category;
import com.stockmanagement.entities.Product;
import com.stockmanagement.models.SearchProductDTO;
import com.stockmanagement.models.SellProductDTO;
import com.stockmanagement.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProduct() {
        Category category = new Category();
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.save(product);

        assertNotNull(savedProduct);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testSearchProducts() {
        SearchProductDTO searchProductDTO = new SearchProductDTO();
        List<Product> products = List.of(new Product());
        when(productRepository.findAll()).thenReturn(products);

        List<Product> foundProducts = productService.search(searchProductDTO);

        assertNotNull(foundProducts);
        assertFalse(foundProducts.isEmpty());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testSellProduct() {
        SellProductDTO sellProductDTO = new SellProductDTO();
        Product product = new Product();
        when(productRepository.findByUuid(any(UUID.class))).thenReturn(Optional.of(product));

        productService.sellProduct(sellProductDTO);

        verify(productRepository, times(1)).findByUuid(any(UUID.class));
        verify(productRepository, times(1)).save(product);
    }
}
