package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class BeanC implements ValidatableBean {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    @Override
    public String toString() {
        return "bean.beanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void init(){
        System.out.println("beanC init method");
    }

    public void destroy(){
        System.out.println("beanC destroy method");
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
