//package com.userDao;
//
//import com.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
////@Transactional(readOnly = true)
//public class UserDao {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public List<User> getAll () {
//
//        List <User> resultList = entityManager.createQuery("select u from User u", User.class).getResultList();
//
//        return resultList;
//    }
//}