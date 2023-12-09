package com.userDao;

import com.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void createUser(User user);

    void deleteUser(long id);

    public void update(User updatedUser, long id);

    User getOne(long id);
}
