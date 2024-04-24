package com.prabhu.productservice.controller;


import com.prabhu.productservice.dto.ProductDTO;
import com.prabhu.productservice.enity.Product;
import com.prabhu.productservice.exception.ProductNotFoundException;
import com.prabhu.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        log.info("Creating new product...");
        Product createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) throws ProductNotFoundException {
        log.info("Fetching product with id: {}", id);
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        log.info("Fetching all products...");
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductDTO productDTO)
            throws ProductNotFoundException {
        log.info("Updating product with id: {}", id);
        Product updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) throws ProductNotFoundException {
        log.info("Deleting product with id: {}", id);
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

