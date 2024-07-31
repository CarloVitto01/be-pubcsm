package com.example.pubcsm.dto;

import java.util.List;

public class OrderRequestDTO {
    private Long personId;
    private List<Long> productIds;

    // Getters and setters
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
