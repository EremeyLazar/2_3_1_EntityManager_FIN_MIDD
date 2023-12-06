package com.controller;

//Servive + interfaces
//User in DAO


import com.model.User;
import com.service.UserServiceImp;
import com.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class UsersController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping(value = "/")
    public String getAll(Model model) {
        List<User> resultList = userServiceImp.getAll();
        model.addAttribute("userlist", resultList);

        return "users";
    }

    //NEW USER!!!
    @GetMapping(value = "/usercreation")
    public String newUser(Model model) {
        model.addAttribute("newuser", new User());
        return "usercreation";
    }

    @PostMapping(value = "/usercreation")
    public String createUser(@ModelAttribute("newuser") User user) {
        userServiceImp.createUser(user);
        return "redirect:/";
    }


    //    DELETE USER!!!
    @GetMapping(value = "/deleteuser")
    public String deleteUser(@RequestParam("id") long id) {
        User user = userServiceImp.getOne(id);
        userServiceImp.deleteUser(id);
        return "redirect:deleted";
    }

    @GetMapping(value = "/deleted")
    public String deleted(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Requested user has been removed!!!");
        model.addAttribute("messages", messages);
        return "deleted";
    }

    //    UPDATE USER!!!
    @GetMapping(value = "/update")
    public String updateUser(ModelMap model, @RequestParam("id") Long id) {
        model.addAttribute("upuser", userServiceImp.getOne(id));
        return "update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("upuser") User updatedUser) {
        userServiceImp.update(updatedUser, updatedUser.getId());
        return "redirect:/";
    }
}
