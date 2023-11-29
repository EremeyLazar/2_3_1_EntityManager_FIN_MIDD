package web.controller;

import userDao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    UserDao userDao = new UserDao();


    private User user;

    int i = 0;

//    @Autowired
//    private UserDao userDao;



    //    @GetMapping(value = "/")
//    public String showUsers(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        userDao.getUserFromList().stream().forEach(x -> messages.add(++i+") "+String.valueOf(x.getName())));
//        model.addAttribute("users", messages);
//        return "user";
//    }
    @GetMapping(value = "/")
    public String showUsers(ModelMap model) {
        model.addAttribute("users", userDao.getAll());
        return "users";
    }

    // @RequestParam НЕ РАБОТАЛ!!!!
    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userDao.getSingleUser(id));
        return "showuser";
    }

    @GetMapping(value = "/newuser")
    public String newUser (Model model) {
        model.addAttribute("newone", new User());
        return "newuser";
    }

    @PostMapping(value = "/newuser")
    public String createUser (@ModelAttribute("newone") User user) {
        userDao.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteuser")
    public String deleteUser (@RequestParam("id") int id) {
        user = userDao.getSingleUser(id);
        userDao.deleteUser(user);

        return "redirect:deleted";
    }

    @GetMapping(value = "/deleted")
    public String deleted (ModelMap model) {

        List<String> messages = new ArrayList<>();
        messages.add("User " + user.getName() + " has been removed!!!");
        model.addAttribute("messages", messages);

        return "deleted";
    }

    @GetMapping(value = "/update")
    public String updateUser (ModelMap model, @RequestParam("id") int id) {
        user = userDao.getSingleUser(id);
        model.addAttribute("upuser", user);

        return "update";
    }

}
