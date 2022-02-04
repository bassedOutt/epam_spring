package com.epam.spring.homework2.config;

import com.epam.spring.homework2.bean.BeanA;
import com.epam.spring.homework2.bean.BeanE;
import com.epam.spring.homework2.bean.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Config2 {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

}
