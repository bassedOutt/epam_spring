package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements ValidatableBean {
    @Value("Derren")
    private String name;
    @Value("5")
    private int value;

    @Override
    public String toString() {
        return "bean.BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("beanA init method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("beanA destroy method");
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
