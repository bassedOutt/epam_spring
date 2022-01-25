package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beanpostprocessors.ValidateFieldsBeanPostProcessor;
import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.context.annotation.*;

@Configuration
@Import(Config2.class)
@PropertySource("hw2.properties")
public class MainConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public ValidateFieldsBeanPostProcessor validateFieldsBeanPostProcessor(){
        return new ValidateFieldsBeanPostProcessor();
    }
}
