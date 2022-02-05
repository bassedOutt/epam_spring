package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User> implements UserRepository {

    @Override
    public void update(User entity) {
        User oldUser = entities.get(Math.toIntExact(entity.getId()));
        oldUser.setAdmin(entity.isAdmin());
        oldUser.setEmail(entity.getEmail());
        oldUser.setName(entity.getName());
        oldUser.setSurname(entity.getSurname());
        oldUser.setPassword(entity.getPassword());
    }

    @PostConstruct
    public void init(){
        User user1 = User.builder()
                .id(User.getNextId())
                .email("obama@us.gov.com")
                .name("Barack")
                .surname("Obama")
                .password("obamapass")
                .isAdmin(false).build();

        User user2 = User.builder()
                .id(User.getNextId())
                .email("trump@us.gov.com")
                .name("Donald")
                .surname("Trump")
                .password("trumppass")
                .isAdmin(false).build();

        entities.addAll(List.of(user1,user2));
    }
}
