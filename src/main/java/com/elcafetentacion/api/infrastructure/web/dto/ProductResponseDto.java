package com.elcafetentacion.api.infrastructure.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer stock;

}
