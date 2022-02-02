package com.example.hw_3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PricingDto {
    private int id;
    private String name;
    private double price;
}
