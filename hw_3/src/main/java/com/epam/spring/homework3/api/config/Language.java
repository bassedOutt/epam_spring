package com.epam.spring.homework3.api.config;

import com.epam.spring.homework3.model.UserLanguage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class Language {

    @Bean
    @SessionScope
    public UserLanguage userLanguage(){
        return new UserLanguage();
    }
}
