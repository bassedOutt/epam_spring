package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.exception.EntityCreationException;
import com.epam.spring.homework3.exception.EntityNotFoundException;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User> implements UserRepository {

    public User findByEmailAndPassword(String email, String password){
        return entities.stream()
                .filter(user1 -> user1.getEmail().equals(email)&&user1.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return entities.stream()
                .filter(user1 -> user1.getEmail().equals(email))
                .findFirst()
                .orElseThrow(()-> new EntityNotFoundException("User with such email does not exist"));
    }

    @Override
    public void insert(User user){
        User foundUser = findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(foundUser!=null)
            throw new EntityCreationException("User with such credentials already exists");
        else
            entities.add(user);
    }

    @PostConstruct
    public void init(){
        User user1 = User.builder()
                .id(UUID.randomUUID().toString())
                .email("obama@us.gov.com")
                .name("Barack")
                .surname("Obama")
                .password("obamapass")
                .isAdmin(false).build();

        User user2 = User.builder()
                .id(UUID.randomUUID().toString())
                .email("trump@us.gov.com")
                .name("Donald")
                .surname("Trump")
                .password("trumppass")
                .isAdmin(false).build();

        entities.addAll(List.of(user1,user2));
    }
}
