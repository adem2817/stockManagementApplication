package com.stockmanagement.controllers;

import com.stockmanagement.models.ProductDTO;
import com.stockmanagement.models.SearchProductDTO;
import com.stockmanagement.models.SellProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    ResponseEntity<?> search(@RequestBody SearchProductDTO searchProductDTO) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    ResponseEntity<?> sellProduct(@RequestBody SellProductDTO sellProductDTO) {
        return ResponseEntity.ok(null);
    }

}
