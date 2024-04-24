package com.prabhu.productservice.service.impl;

import com.prabhu.productservice.dto.ProductDTO;
import com.prabhu.productservice.enity.Product;
import com.prabhu.productservice.exception.ProductNotFoundException;
import com.prabhu.productservice.mapper.ProductMapper;
import com.prabhu.productservice.repository.ProductRepository;
import com.prabhu.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        log.info("Creating new product...");
        Product product = productMapper.convertToProduct(productDTO);
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String id) throws ProductNotFoundException {
        log.info("Fetching product with id: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all products...");
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(String id, ProductDTO productDTO) throws ProductNotFoundException {
        log.info("Updating product with id: {}", id);
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        Product productToUpdate = productMapper.convertToProduct(productDTO);
        productToUpdate.setId(id);
        return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProduct(String id) throws ProductNotFoundException {
        log.info("Deleting product with id: {}", id);
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}

