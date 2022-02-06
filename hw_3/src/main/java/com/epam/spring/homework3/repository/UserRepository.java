package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.User;

public interface UserRepository extends CrudRepository<User> {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
