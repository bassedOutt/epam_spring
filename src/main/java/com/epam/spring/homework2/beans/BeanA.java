package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, ValidatableBean {

    @Value("Mark")
    private String name;
    @Value("4")
    private int value;

    @Override
    public void afterPropertiesSet() {
        System.out.println("beanA init method");
    }

    @Override
    public void destroy() {
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
