package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanF implements ValidatableBean {
    @Value("Lia")
    private String name;
    @Value("6")
    private int value;

    @Override
    public String toString() {
        return "bean.BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void validate() throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Name can not be null");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be greater than zero");
        }
    }
}
