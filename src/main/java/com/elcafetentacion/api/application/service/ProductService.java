package com.elcafetentacion.api.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elcafetentacion.api.domain.model.Product;
import com.elcafetentacion.api.domain.ports.in.IProductUseCases;
import com.elcafetentacion.api.domain.ports.out.IProductPersistencePort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductUseCases{

    private final IProductPersistencePort persistence;

    @Override
    public Product createProduct(Product product) {
        return persistence.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct= persistence.findById(id);
        if(existingProduct.isPresent()){
            Product updateProduct=existingProduct.get();
            updateProduct.setName(product.getName());
            updateProduct.setCategory(product.getCategory());
            updateProduct.setPrice(product.getPrice());
            
            Product saveProduct= persistence.save(updateProduct);
            return saveProduct;
        }else{
            throw new IllegalArgumentException("Product  with Id :" + id + " not Found" );
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> existingProduct= persistence.findById(id);
        if(!existingProduct.isPresent()){
            throw new IllegalArgumentException("Product  with Id :" + id + " not Found" );
        }
        persistence.delete(id);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return persistence.findById(id);
        
    }

    @Override
    public List<Product> getAll() {
        return persistence.findAll();
    }

}
