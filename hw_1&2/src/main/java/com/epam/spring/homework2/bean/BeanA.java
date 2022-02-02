package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.NeedsValidation;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

@NeedsValidation
public class BeanA implements InitializingBean, DisposableBean {

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

}
