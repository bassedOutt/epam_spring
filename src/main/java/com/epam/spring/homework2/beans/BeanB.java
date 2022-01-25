package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements ValidatableBean {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    @Override
    public String toString() {
        return "bean.BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void init(){
        System.out.println("beanB init method");
    }

    public void destroy(){
        System.out.println("beanB destroy method");
    }

    public void init2(){
        System.out.println("beanB init2 method");
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
