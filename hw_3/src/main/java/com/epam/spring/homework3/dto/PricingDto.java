package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PricingDto implements EntityDto {
    private String id;
    private String name;
    private double price;
}
