package com.elcafetentacion.api.infrastructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.elcafetentacion.api.domain.model.Product;
import com.elcafetentacion.api.domain.ports.out.IProductPersistencePort;
import com.elcafetentacion.api.infrastructure.jpaRepository.JpaProductRepository;
import com.elcafetentacion.api.infrastructure.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements IProductPersistencePort  {

    private final ProductMapper mapper;
    private final JpaProductRepository repository;

    @Override
    public Product save(Product product) {
        return mapper.toDomain(repository.save(mapper.toEntity(product)));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id).map(product-> mapper.toDomain(product));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
                                   .map(product-> mapper.toDomain(product))
                                   .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
