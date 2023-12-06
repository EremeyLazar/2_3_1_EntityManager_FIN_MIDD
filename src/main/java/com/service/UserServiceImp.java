package com.service;

import com.model.User;
import com.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserServiceImp {

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

    @Transactional
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
//
//
//    //    UPDATE USER!!!
//    @Transactional
//    public void update(User updatedUser, Long id) {
//        userDao.update(updatedUser, id);
//    }
}
