package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import service.Service;
import service.ServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
        Service service = new ServiceImp();


    @GetMapping(value = "/cars")
    public String showCars (HttpServletRequest request, ModelMap model) {
        int carsNum = Integer.parseInt(request.getParameter("carsNum"));
        model.addAttribute("carsnum", carsNum);

        if (carsNum > 5) {
            carsNum = 5;
        }

        List<String> messages = new ArrayList<>();
        messages.add("Please, see the list of " + carsNum + " cars." );
        service.getCarsFromList(carsNum).stream().forEach(x -> messages.add(String.valueOf(x)));
        model.addAttribute("messages", messages);

        return "cars";
    }
}


