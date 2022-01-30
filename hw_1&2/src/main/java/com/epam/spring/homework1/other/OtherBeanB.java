package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanA;
import com.epam.spring.homework1.beans.BeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class OtherBeanB {

    private BeanB beanB;

    @Autowired
    public void setBeanA(BeanB beanB){
        this.beanB = beanB;
        System.out.println(this.getClass().getSimpleName()+". "+this.beanB.getClass().getSimpleName()+" was injected via setter");

    }
}
