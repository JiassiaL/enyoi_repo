package com.elcafetentacion.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    Long id;
    String name;
    String document;
    DocumentType documentType;
    String email;
    String address;
    String city;
    String cellphone;

}
