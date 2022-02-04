package com.epam.spring.homework2.beanfactorypostprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ChangeInitMethodBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println(getClass().getSimpleName()+" started");
        configurableListableBeanFactory.getBeanDefinition("beanB").setInitMethodName("init2");
        System.out.println(getClass().getSimpleName()+" changed init method to init2");
    }
}
