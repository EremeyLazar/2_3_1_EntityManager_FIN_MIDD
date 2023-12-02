package com.web.controller;

import com.model.User;
import com.userDao.UserDao;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private EntityManager entityManager;




    private UserDao userDao = new UserDao();

    Long tempId;

    @GetMapping(value = "/test")
    public String getTestTwo (User user) {

        return "users";
    }

    @GetMapping(value = "/")
    public String getTest (Model model) {
        List <User> resultList = entityManager.createQuery("select u from User u", User.class).getResultList();
        model.addAttribute("userlist", resultList );

        return "users";
    }

    @GetMapping (value = "/showuser")
    public User getOne (Long id) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("id"), id));
        User user = entityManager.createQuery(query).getSingleResult();

        return user;
    }

    @GetMapping(value = "/usercreation")
    public String newUser (Model model) {
        model.addAttribute("newuser", new User());
        return "usercreation";
    }

    @PostMapping(value = "/usercreation")
    public String createUser (@ModelAttribute("newuser") User user) {
        entityManager.persist(user);

        //nested exception is javax.persistence.TransactionRequiredException:
        // No EntityManager with actual transaction available for current thread
        // - cannot reliably process 'persist' call

        return "redirect:/";
    }

    @GetMapping(value = "/deleteuser")
    public String deleteUser (@RequestParam("id") long id) {
//        User user = entityManager.find(User.class, id);
//        entityManager.remove(user);


        //Request processing failed; nested exception is javax.persistence.
        // TransactionRequiredException: Executing an update/delete query


        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaDelete <User> delete = criteriaBuilder.createCriteriaDelete(User.class);
        Root root = delete.from(User.class);
        delete.where(criteriaBuilder.equal(root.get("id"), id));
        this.entityManager.createQuery(delete).executeUpdate();


        return "redirect:deleted";
    }

    @GetMapping(value = "/deleted")
    public String deleted (ModelMap model) {

        List<String> messages = new ArrayList<>();
        messages.add("User " + " has been removed!!!");
        model.addAttribute("messages", messages);


        return "deleted";
    }

    @GetMapping(value = "/update")
    public String updateUser (ModelMap model, @RequestParam("id") Long id) {
        tempId = id;
        model.addAttribute("upuser", getOne(id));
        return "update";
    }

    @PatchMapping(value = "/update")
    public String update (@ModelAttribute("upuser") @Valid User user, BindingResult br) {
        if (br.hasErrors()) {return "/update";}

        User needsUpdate = userDao.getSingleUser(tempId);
        needsUpdate.setName(user.getName());
        needsUpdate.setCell(user.getCell());
        needsUpdate.setCountry(user.getCountry());
        needsUpdate.setSalary(user.getSalary());
        needsUpdate.setDl(user.getDl());


        return "redirect:/";
    }



}
