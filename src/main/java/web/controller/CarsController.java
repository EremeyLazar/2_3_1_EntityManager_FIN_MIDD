package web.controller;

import userDao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    UserDao userDao = new UserDao();

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam("count") int carsNum, ModelMap model) {

        if (carsNum > 5) {
            carsNum = 5;
        }

        List<String> messages = new ArrayList<>();
        messages.add("Please, see the list of " + carsNum + " out of 5 cars.");
        userDao.getCarsFromList(carsNum).stream().forEach(x -> messages.add(String.valueOf(x)));
        model.addAttribute("messages", messages);

        return "cars";
    }
}


