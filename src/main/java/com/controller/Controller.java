package com.controller;

import com.model.User;
import com.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    User user;
    Long tempId;

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/")
    public String getAll(Model model) {
        List<User> resultList = userDao.getAll();
        model.addAttribute("userlist", resultList);

        return "users";
    }

    @GetMapping(value = "/showuser")
    public String getOne(Model model, Long id) {
        User user = userDao.getOne(14L);
        model.addAttribute(user);
        return "showuser";
    }


    //NEW USER!!!
    @GetMapping(value = "/usercreation")
    public String newUser(Model model) {
        model.addAttribute("newuser", new User());
        return "usercreation";
    }

    @Transactional
    @PostMapping(value = "/usercreation")
    public String createUser(@ModelAttribute("newuser") User user) {
        userDao.createUser(user);
        return "redirect:/";
    }


    //    DELETE USER!!!
    @GetMapping(value = "/deleteuser")
    public String deleteUser(@RequestParam("id") long id) {
        user = userDao.getOne(id);
        userDao.deleteUser(id);
        return "redirect:deleted";
    }

    @GetMapping(value = "/deleted")
    public String deleted(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("User " + user.getName() + " has been removed!!!");
        model.addAttribute("messages", messages);
        return "deleted";
    }


//    UPDATE USER!!!
    @GetMapping(value = "/update")
    public String updateUser(ModelMap model, @RequestParam("id") Long id) {
        tempId = id;
        model.addAttribute("upuser", userDao.getOne(id));
        return "update";
    }

    @Transactional
    @PatchMapping(value = "/update")
    public String update(@ModelAttribute("upuser") User updatedUser) {
        userDao.update(updatedUser, tempId);
        return "redirect:/";
    }
}
