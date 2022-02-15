package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Builder
@Entity
public class Pricing {
    private String id;
    private String name;
    private double price;
}
