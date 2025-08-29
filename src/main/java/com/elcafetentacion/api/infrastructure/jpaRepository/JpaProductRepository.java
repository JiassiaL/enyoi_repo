package com.elcafetentacion.api.infrastructure.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elcafetentacion.api.infrastructure.persistence.ProductEntity;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

}
