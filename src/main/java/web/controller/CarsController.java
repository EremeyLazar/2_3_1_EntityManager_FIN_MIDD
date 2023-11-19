package web.controller;

import model.Cars;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Here will be cars");
        model.addAttribute("messages", messages);
        return "cars";
    }

    Cars car1 = new Cars("Viktor", "Mustang", 00165);
    Cars car2 = new Cars("Ignat", "Mustang", 21453);
    Cars car3 = new Cars("Georgiy", "Mustang", 63002);
    Cars car4 = new Cars("James", "Mustang", 00007);
    Cars car5 = new Cars("Kimanilau", "Mustang", 12210);

}
