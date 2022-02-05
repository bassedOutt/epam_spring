package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pricing implements Entity{
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