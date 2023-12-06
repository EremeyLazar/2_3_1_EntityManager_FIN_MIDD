package com.userDao;

import com.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public User getOne(Long id);
    public void createUser(User user);
    public void deleteUser(long id);
    public void update(User updatedUser, Long id);
}
