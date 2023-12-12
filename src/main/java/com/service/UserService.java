package com.service;

import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void createUser(User user);

    void deleteUser(long id);

    void update(User updatedUser, long id);

    User getOne(long id);
}

