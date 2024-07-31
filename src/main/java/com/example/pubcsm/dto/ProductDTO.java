package com.example.pubcsm.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity; // Aggiungi il campo quantity

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() { // Getter per quantity
        return quantity;
    }

    public void setQuantity(Integer quantity) { // Setter per quantity
        this.quantity = quantity;
    }
}
