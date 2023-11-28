package web.controller;

import UserDAOImp.UserDao;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    UserDao userDao = new UserDao();
    User user = new User();

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
    public String newUser (ModelMap model) {
        User user = new User();
        model.addAttribute("newone", user);
        return "newuser";
    }

    @PostMapping
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

    @GetMapping(value = "/updateuser")
    public String updateUser (@RequestParam("id") int id, ModelMap model) {
        user = userDao.getSingleUser(id);


        return null;
    }

}
