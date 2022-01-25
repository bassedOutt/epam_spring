package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BeanD implements ValidatableBean {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "bean.beanD{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void init(){
        System.out.println("beanD init method");
    }

    public void destroy(){
        System.out.println("beanD destroy method");
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
