package com.stockmanagement.controllers;

import com.stockmanagement.entities.Category;
import com.stockmanagement.models.CategoryDTO;
import com.stockmanagement.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Api(value = "Category Controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(value = "Add a new category")
    @PostMapping
    ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(new Category().toCategory(categoryDTO));
        return ResponseEntity.accepted().build();
    }

    @ApiOperation(value = "Add a subcategory to an existing category")
    @PostMapping("/{category_id}")
    ResponseEntity<?> addSubCategory(@PathVariable(name = "category_id") UUID categoryId,
                                     @RequestBody CategoryDTO categoryDTO) {
        Category parentCategory = categoryService.getById(categoryId);
        categoryService.save(new Category().toSubCategory(categoryDTO, parentCategory));
        return ResponseEntity.accepted().build();
    }

}
