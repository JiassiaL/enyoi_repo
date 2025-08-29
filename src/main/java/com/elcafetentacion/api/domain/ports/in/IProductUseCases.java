package com.elcafetentacion.api.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.elcafetentacion.api.domain.model.Product;

public interface IProductUseCases {

    //write methods
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    
    ///Reading methods
    Optional<Product> getById(Long id);
    List<Product> getAll();
    


}
