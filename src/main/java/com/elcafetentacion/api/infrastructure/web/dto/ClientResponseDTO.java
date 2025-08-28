package com.elcafetentacion.api.infrastructure.web.dto;

import com.elcafetentacion.api.domain.model.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    Long id;
    String name;
    String document;
    DocumentType documentType;
    String email;
    String address;
    String city;
    String cellphone;
}
