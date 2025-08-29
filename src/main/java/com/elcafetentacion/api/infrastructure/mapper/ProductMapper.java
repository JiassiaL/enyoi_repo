package com.elcafetentacion.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.elcafetentacion.api.domain.model.Product;
import com.elcafetentacion.api.infrastructure.persistence.ProductEntity;
import com.elcafetentacion.api.infrastructure.web.dto.ProductRequestDto;
import com.elcafetentacion.api.infrastructure.web.dto.ProductResponseDto;

@Component
public class ProductMapper {

    //Domain - Entity

    public Product toDomain(ProductEntity entity){
        return new Product(
            entity.getId(),
            entity.getName(),
            entity.getCategory(),
            entity.getPrice(),
            entity.getStock()
        );
    }
    public ProductEntity toEntity(Product product){
        return new ProductEntity(
            product.getId(),
            product.getName(),
            product.getCategory(),
            product.getPrice(),
            product.getStock()
        );
    }
    // Product - Dtos

    public Product requestDtoToDomain(ProductRequestDto requestDto){
        return new Product(
            null, 
            requestDto.getName(), 
            requestDto.getCategory(), 
            requestDto.getPrice(), 
            requestDto.getStock());
    }
    public ProductResponseDto domainToResponse(Product product){
        return new ProductResponseDto(

            product.getId(), 
            product.getName(), 
            product.getCategory(), 
            product.getPrice(), 
            product.getStock()

        );
    }

}
