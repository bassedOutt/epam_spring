package com.epam.spring.homework2.bean;
import com.epam.spring.homework2.validation.NeedsValidation;
import org.springframework.beans.factory.annotation.Value;


@NeedsValidation
public class BeanD  {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "bean.beanD{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public void init(){
        System.out.println("beanD init method");
    }

    public void destroy(){
        System.out.println("beanD destroy method");
    }

}
