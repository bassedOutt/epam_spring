package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beanfactorypostprocessors.ChangeInitMethodBeanFactoryPostProcessor;
import com.epam.spring.homework2.beanpostprocessors.ValidateFieldsBeanPostProcessor;
import com.epam.spring.homework2.bean.BeanB;
import com.epam.spring.homework2.bean.BeanC;
import com.epam.spring.homework2.bean.BeanD;
import org.springframework.context.annotation.*;

@Configuration
@Import(Config2.class)
@PropertySource("classpath:application.properties")
public class MainConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD(){
        return new BeanD();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB beanB(){
        return new BeanB();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC beanC(){
        return new BeanC();
    }

    @Bean
    public ValidateFieldsBeanPostProcessor validateFieldsBeanPostProcessor(){
        return new ValidateFieldsBeanPostProcessor();
    }

    @Bean
    public ChangeInitMethodBeanFactoryPostProcessor changeInitMethodBeanFactoryPostProcessor(){
        return new ChangeInitMethodBeanFactoryPostProcessor();
    }

}

