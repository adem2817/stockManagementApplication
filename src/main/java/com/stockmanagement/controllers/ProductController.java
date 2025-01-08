package com.stockmanagement.controllers;

import com.stockmanagement.entities.Category;
import com.stockmanagement.entities.Product;
import com.stockmanagement.models.ProductDTO;
import com.stockmanagement.models.SearchProductDTO;
import com.stockmanagement.models.SellProductDTO;
import com.stockmanagement.services.CategoryService;
import com.stockmanagement.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Product Controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @ApiOperation(value = "Add a new product", response = ResponseEntity.class)
    @PostMapping
    ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        Category category = categoryService.getById(productDTO.getUuid());
        productService.save(new Product().toProduct(productDTO, category));
        return ResponseEntity.accepted().build();
    }

    @ApiOperation(value = "Search products", response = List.class)
    @PostMapping
    ResponseEntity<List<Product>> search(@RequestBody SearchProductDTO searchProductDTO) {
        return ResponseEntity.ok(productService.search(searchProductDTO));
    }

    @ApiOperation(value = "Sell a product", response = ResponseEntity.class)
    @PostMapping
    ResponseEntity<?> sellProduct(@RequestBody SellProductDTO sellProductDTO) {
        productService.sellProduct(sellProductDTO);
        return ResponseEntity.noContent().build();
    }

}
