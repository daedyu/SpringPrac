package org.example.springprac.controller;

import lombok.RequiredArgsConstructor;
import org.example.springprac.model.Product;
import org.example.springprac.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("data")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product) {
        productService.save(product);
    }
}