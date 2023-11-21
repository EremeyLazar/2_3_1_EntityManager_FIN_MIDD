package web.controller;

import model.Cars;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

//    @GetMapping(value = "/cars")
//    public String printCars(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Here will be cars");
//        model.addAttribute("messages", messages);
//        return "cars";
//    }

    @GetMapping(value = "/cars")
    public String showCars (HttpServletRequest request, ModelMap model) {
        int carsNum = Integer.parseInt(request.getParameter("carsNum"));
        model.addAttribute("carsnum", carsNum);

        List<String> messages = new ArrayList<>();
        messages.add("Here will be cars");
        messages.add(String.valueOf(carsNum));
        model.addAttribute("messages", messages);

        return "cars";
    }
}


