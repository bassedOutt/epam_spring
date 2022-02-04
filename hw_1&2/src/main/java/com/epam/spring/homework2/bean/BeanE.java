package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.NeedsValidation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@NeedsValidation
public class BeanE {
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
        System.out.println("beanA post consruct method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("beanA preDestroy method");
    }

}
