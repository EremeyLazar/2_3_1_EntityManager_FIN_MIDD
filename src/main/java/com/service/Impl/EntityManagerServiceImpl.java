package com.service.Impl;

import com.model.User;
import com.service.EntityManagerService;
import com.web.config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class EntityManagerServiceImpl implements EntityManagerService {

    @Override
    public String addNewUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transactional = null;
        try {
            transactional = session.beginTransaction();
            session.save(user);
            transactional.commit();
            return "new user saved";

//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
//            Root<User> root = query.from(User.class);

        } catch (Exception e) {
            if (transactional != null) {
                transactional.rollback();
            } return "User is not saved";
        }finally {
            session.close();
        }
    }
}
