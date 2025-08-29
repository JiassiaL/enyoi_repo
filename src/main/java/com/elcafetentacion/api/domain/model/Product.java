package com.elcafetentacion.api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer stock;

    public boolean  validateStock(Integer quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("quantity must be greater than zero");
        }
        return (quantity< this.stock);

    }
    public void incrementStock(Integer quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("quantity must be greater than zero");
        }
        this.stock += quantity;

    }
    public void decrementStock(Integer quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("quantity must be greater than zero");
        }
        if(quantity>this.stock){
            throw new IllegalArgumentException("Insuficient Stock");
        }
        this.stock -= quantity;

    }

}
