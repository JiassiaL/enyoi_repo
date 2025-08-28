package com.elcafetentacion.api.infrastructure.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elcafetentacion.api.infrastructure.persistence.ClientEntity;

public interface JpaClientRepository  extends JpaRepository<ClientEntity, Long>{

}
