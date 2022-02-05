package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PricingDto implements EntityDto {
    private Long id;
    private String name;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
