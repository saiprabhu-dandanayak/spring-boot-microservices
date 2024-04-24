package com.prabhu.productservice.mapper;


import com.prabhu.productservice.dto.ProductDTO;
import com.prabhu.productservice.enity.Product;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertToProductDTO(Product product) {
        try {
            log.info(">>> INSIDE ProductMapper: convertToProductDTO() Converting entity to DTO");
            return modelMapper.map(product, ProductDTO.class);
        } catch (NullPointerException exception) {
            log.error(">>> INSIDE ProductMapper: convertToProductDTO() Converting entity to DTO");
            throw new NullPointerException("NullPointerException in converting to DTO");
        }
    }

    public Product convertToProduct(ProductDTO productDTO) {
        try {
            log.info(">>> INSIDE ProductMapper: convertToProduct() Converting DTO to entity");
            return modelMapper.map(productDTO, Product.class);
        } catch (NullPointerException exception) {
            log.error(">>> INSIDE ProductMapper: convertToProduct() Converting DTO to entity");
            throw new NullPointerException("NullPointerException in converting to entity");
        }
    }
}

