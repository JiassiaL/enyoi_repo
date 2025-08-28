package com.elcafetentacion.api.infrastructure.persistence;

import org.hibernate.validator.constraints.UniqueElements;

import com.elcafetentacion.api.domain.model.DocumentType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    
    String name;
    
    @Column(nullable = false, unique=true)
    String document;
    
    DocumentType documentType;

    String email;

    String address;

    String city;

    String cellphone;
}
