package com.elcafetentacion.api.infrastructure.web.dto;


import com.elcafetentacion.api.domain.model.DocumentType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {
    @NotBlank
    @Size(max = 100)
    String name;

   
    @NotBlank
    String document;

    @NotNull
    //@Pattern(regexp = "DNI|PP|NIT|RUT", message = "document type is not valid")
    DocumentType documentType;

    @Email
    @NotBlank(message="email is required")
    @Size(max = 50)
    String email;

    @NotBlank(message="address is required")
    @Size(max = 100)
    String address;

    @NotBlank(message="city's name is required")
    @Size(max = 30)
    String city;
    
    @NotBlank(message="cellphone is required")
    @Size(max = 10)
    String cellphone;
}
