package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
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

    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;
}
