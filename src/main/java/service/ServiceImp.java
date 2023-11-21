package service;

import model.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ServiceImp {
    Cars car1 = new Cars("Viktor", "Mustang", 00165);
    Cars car2 = new Cars("Ignat", "Mustang", 21453);
    Cars car3 = new Cars("Georgiy", "Mustang", 63002);
    Cars car4 = new Cars("James", "Mustang", 00007);
    Cars car5 = new Cars("Kimanilau", "Mustang", 12210);

    private List<Cars> carsList = new ArrayList<>() ;

    public List <Cars> carsList () {
        List<Cars> carsList = new ArrayList<>() ;
        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        carsList.add(car4);
        carsList.add(car5);
    return carsList;
    }

    public List <Cars> getCarsList (int num) {
        List <Cars> result = new ArrayList <Cars> () ;
        result = carsList().stream().limit(num).collect(Collectors.toList());
        return result;
    }

}
