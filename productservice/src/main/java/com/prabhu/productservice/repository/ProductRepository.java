package com.prabhu.productservice.repository;

import com.prabhu.productservice.enity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}

