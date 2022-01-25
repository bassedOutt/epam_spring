package com.epam.spring.homework2.beanpostprocessors;

import com.epam.spring.homework2.validators.ValidatableBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ValidateFieldsBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ValidatableBean){
            ((ValidatableBean) bean).validate();
        }
        return bean;
    }
}
