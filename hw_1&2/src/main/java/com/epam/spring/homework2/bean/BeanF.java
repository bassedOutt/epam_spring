package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.NeedsValidation;
import org.springframework.beans.factory.annotation.Value;

@NeedsValidation
public class BeanF {
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
}
