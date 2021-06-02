package com.codesessive.task.controller;


import com.codesessive.task.model.Category;
import com.codesessive.task.model.Product;
import com.codesessive.task.model.SubCategory;
import com.codesessive.task.service.IStockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sm")
public class StockManagementController {

    @Autowired
    IStockManagementService stockManagementService;

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return stockManagementService.addCategory(category);
    }

    @PostMapping("/addSubCategory")
    public SubCategory addSubCategory(@RequestBody SubCategory subCategory){
        return stockManagementService.addSubCategory(subCategory);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return stockManagementService.addProduct(product);
    }

    @PostMapping("/sellProduct")
    public Boolean sellProduct(@RequestParam("id") Integer id, @RequestParam("count") Integer stockCount){
        return stockManagementService.sellProduct(id, stockCount);
    }

    @GetMapping("/findbyname/{name}")
    public List<Product> findByName(@PathVariable("name") String name) {
        return stockManagementService.findByName(name);
    }

    @PostMapping("/findbypriceinterval")
    public List<Product> findByPriceInterval(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        return stockManagementService.findByPriceInterval(min, max);
    }

}
