package com.epam.spring.homework2.bean;

import com.epam.spring.homework2.validation.NeedsValidation;
import org.springframework.beans.factory.annotation.Value;

@NeedsValidation
public class BeanB {
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


}
