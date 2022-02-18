package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Pricing {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
}
