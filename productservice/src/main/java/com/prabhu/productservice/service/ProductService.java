package com.prabhu.productservice.service;


import com.prabhu.productservice.dto.ProductDTO;
import com.prabhu.productservice.enity.Product;
import com.prabhu.productservice.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDTO productDTO);

    Product getProductById(String id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product updateProduct(String id, ProductDTO productDTO) throws ProductNotFoundException;

    void deleteProduct(String id) throws ProductNotFoundException;
}
