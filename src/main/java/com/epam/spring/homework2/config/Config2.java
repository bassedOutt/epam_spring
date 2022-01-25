package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beanfactorypostprocessors.ChangeInitMethodBeanFactoryPostProcessor;
import com.epam.spring.homework2.beans.BeanA;
import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanE;
import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class Config2 {
    @Bean
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF();
    }

    @Bean
    public BeanE beanE(){
        return new BeanE();
    }

    @Bean
    public ChangeInitMethodBeanFactoryPostProcessor changeInitMethodBeanFactoryPostProcessor(){
        return new ChangeInitMethodBeanFactoryPostProcessor();
    }
}
