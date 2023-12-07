package com.service;

import com.model.User;
import com.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        List<User> resultList = userDao.getAll();
        return resultList;
    }

    public User getOne(Long id) {
        User user = userDao.getOne(id);
        return user;
    }


    public void createUser(User user) {
        userDao.createUser(user);
    }


    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }


    public void update(User updatedUser, Long id) {
        userDao.update(updatedUser, id);
    }
}
