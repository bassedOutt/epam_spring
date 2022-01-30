package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfig.class);

        Pet pet = (Pet) applicationContext.getBean("pet");
        pet.printPets();

        Cheetah cheetah1 = applicationContext.getBean(Cheetah.class);
        Cheetah cheetah2 = (Cheetah) applicationContext.getBean("cheetah2");

        System.out.println(cheetah1);
        System.out.println(cheetah2);

    }
}
