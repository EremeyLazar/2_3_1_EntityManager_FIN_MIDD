package com.web.controller;

import com.model.User;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {

//    UserDao userDao = new UserDao();

    Long tempId;
    private User user;


//    @GetMapping(value = "/deleteuser")
//    public String deleteUser (@RequestParam("id") int id) {
//        user = userDao.getSingleUser(id);
//        userDao.deleteUser(user);
//
//        return "redirect:deleted";
//    }
//
//    @GetMapping(value = "/deleted")
//    public String deleted (ModelMap model) {
//
//        List<String> messages = new ArrayList<>();
//        messages.add("User " + user.getName() + " has been removed!!!");
//        model.addAttribute("messages", messages);
//
//        return "deleted";
//    }

//    @GetMapping(value = "/update")
//    public String updateUser (ModelMap model, @RequestParam("id") Long id) {
//        tempId = id;
//        model.addAttribute("upuser", userDao.getSingleUser(id));
//        return "update";
//    }
//
//    @PatchMapping(value = "/update")
//    public String update (@ModelAttribute("upuser") @Valid User user, BindingResult br) {
//        if (br.hasErrors()) {return "/update";}
//        userDao.update(tempId, user);
//
//
//        return "redirect:/";
//    }

}
