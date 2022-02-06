package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pricing implements Entity{
    private String id;
    private String name;
    private double price;
}
