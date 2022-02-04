package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    private List<User> userList;

    @Override
    public List<User> getAll() {
        log.info("returning list of users: {}",userList);
        return userList;
    }

    @Override
    public User get(Long id) {
        log.info("user with id {} was found",id);
        return userList.get(Math.toIntExact(id));
    }

    @Override
    public void insert(User entity) {
        log.info("Inserting user: {}",entity);
        userList.add(entity);
    }

    @Override
    public void update(User entity) {
        log.info("updating user: {}",entity);
        User oldUser = userList.get(Math.toIntExact(entity.getId()));
        oldUser.setAdmin(entity.isAdmin());
        oldUser.setEmail(entity.getEmail());
        oldUser.setName(entity.getName());
        oldUser.setSurname(entity.getSurname());
        oldUser.setPassword(entity.getPassword());
    }

    @Override
    public void delete(User entity) {
        log.info("deleting user with id: {}",entity.getId());
        userList.remove(Math.toIntExact(entity.getId()));
    }

    @PostConstruct
    public void init(){
        userList = new ArrayList<>();
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

        userList.addAll(List.of(user1,user2));
    }
}
