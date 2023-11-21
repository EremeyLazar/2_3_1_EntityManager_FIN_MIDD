package service;

import model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ServiceImp implements Service {
    Cars car1 = new Cars("Viktor", "Mustang", 00165);
    Cars car2 = new Cars("Ignat", "Mustang", 21453);
    Cars car3 = new Cars("Georgiy", "Mustang", 63002);
    Cars car4 = new Cars("James", "Mustang", 00007);
    Cars car5 = new Cars("Kimanilau", "Mustang", 12210);

    private List<Cars> carsList = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5));

    @Override
    public List<Cars> getCarsFromList(int num) {
        return carsList.stream().limit(num).collect(Collectors.toList());
    }
}
