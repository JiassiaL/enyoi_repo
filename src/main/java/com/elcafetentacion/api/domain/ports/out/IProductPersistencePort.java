package com.elcafetentacion.api.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.elcafetentacion.api.domain.model.Product;

public interface IProductPersistencePort {

    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void delete(Long id);

}
