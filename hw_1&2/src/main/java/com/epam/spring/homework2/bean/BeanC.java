package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.NeedsValidation;
import org.springframework.beans.factory.annotation.Value;

@NeedsValidation
public class BeanC  {
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


}
