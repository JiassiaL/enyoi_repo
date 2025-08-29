package com.elcafetentacion.api.infrastructure.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcafetentacion.api.domain.ports.in.IProductUseCases;
import com.elcafetentacion.api.infrastructure.mapper.ProductMapper;
import com.elcafetentacion.api.infrastructure.web.dto.ProductRequestDto;
import com.elcafetentacion.api.infrastructure.web.dto.ProductResponseDto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductMapper mapper;
    private final IProductUseCases usesCases;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid@RequestBody ProductRequestDto requestDto){
        var productResponse = mapper.domainToResponse(usesCases.createProduct(mapper.requestDtoToDomain(requestDto)));
        return ResponseEntity.ok(productResponse);

    }
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long productId,@RequestBody ProductRequestDto requestDto){
        ProductResponseDto productResponse = mapper.domainToResponse(usesCases.updateProduct(productId, mapper.requestDtoToDomain(requestDto)));
        return ResponseEntity.ok(productResponse);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        usesCases.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long productId){
        return usesCases.getById(productId).map(mapper::domainToResponse)
                                         .map(ResponseEntity::ok)
                                         .orElse(ResponseEntity.notFound().build());

                                           
    }
    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getAll(){
        List<ProductResponseDto> products= usesCases.getAll().stream().map(mapper::domainToResponse).collect(Collectors.toList());
        return ResponseEntity.ok(products);      

    }






}
