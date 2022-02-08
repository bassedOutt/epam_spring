package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.model.User;

public interface UserRepository extends CrudRepository<User> {
    User findByEmail(String email);
}
