package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PricingDto implements EntityDto {
    private String id;
    private String name;
    private double price;
}
