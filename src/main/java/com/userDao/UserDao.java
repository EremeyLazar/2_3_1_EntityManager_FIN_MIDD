package com.userDao;

import com.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();

    public User getOne(Long id);

    public void createUser(User user);

    public void deleteUser(long id);

    public void update(User updatedUser, Long id);
}
