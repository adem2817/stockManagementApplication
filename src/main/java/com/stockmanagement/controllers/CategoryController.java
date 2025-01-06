package com.stockmanagement.controllers;

import com.stockmanagement.models.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping
    ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(null);
    }

    @PostMapping
    ResponseEntity<?> addSubCategory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(null);
    }

}
