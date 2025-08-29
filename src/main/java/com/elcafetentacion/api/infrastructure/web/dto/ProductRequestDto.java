package com.elcafetentacion.api.infrastructure.web.dto;



import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    @NotBlank()
    @Size(min=1,max=50)
    private String name;
    @NotBlank()
    @Size(min=1,max=50)
    private String category;
    @DecimalMin(value = "0.0")
    private Double price;
    @Min(value= 0)
    private Integer stock;

}
