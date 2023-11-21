package web.controller;

import model.Cars;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import service.ServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
        ServiceImp imp = new ServiceImp();


    @GetMapping(value = "/cars")
    public String showCars (HttpServletRequest request, ModelMap model) {
        int carsNum = Integer.parseInt(request.getParameter("carsNum"));
        model.addAttribute("carsnum", carsNum);

        List<String> messages = new ArrayList<>();
        messages.add("Here will be cars");
        messages.add(String.valueOf(carsNum));

        if (carsNum > 5) {
            carsNum = 5;
        }

        imp.getCarsList(carsNum).stream().forEach(x -> messages.add(String.valueOf(x)));

        model.addAttribute("messages", messages);




        return "cars";
    }
}


