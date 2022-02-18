package com.epam.spring.homework3.service;

import com.epam.spring.homework3.model.UserLanguage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class LanguageService {

    public LanguageService() {
        languages.add("en");
        languages.add("ua");
    }

    private static ApplicationContext context;

    private static final Set<String> languages = new HashSet<>();

    @Autowired
    public void setContext(ApplicationContext context) {
        LanguageService.context = context;
    }

    public static String getUserLanguage() {
        return context.getBean(UserLanguage.class).getLanguage();
    }

    public static void setUserLanguage(String language) {
        log.info("setting new language to : {}", language);
        if (languages.stream().noneMatch(language::equals)) {
            log.error("No such language");
            throw new IllegalArgumentException("Language not supported");
        }
        context.getBean(UserLanguage.class).setLanguage(language);
    }
}
