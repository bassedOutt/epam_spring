package com.epam.spring.homework1.config;

import com.epam.spring.homework1.pet.Cheetah;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.epam.spring.homework1.other")
@Import(PetConfig.class)
public class OtherConfig { }

