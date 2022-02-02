package com.example.hw_3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pricing implements Entity{
    private int id;
    private String name;
    private double price;
}
