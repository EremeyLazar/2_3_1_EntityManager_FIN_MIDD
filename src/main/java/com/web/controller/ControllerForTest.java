package com.web.controller;

import com.model.User;
import com.service.EntityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerForTest {

    @Autowired
    private EntityManagerService entityManagerService;

    @GetMapping("/save")
    public String saveToBase (@RequestParam String name,
                              @RequestParam String cell,
                              @RequestParam String country,
                              @RequestParam int salary,
                              @RequestParam String dl) {

        return entityManagerService.addNewUser(new User (5L, name, cell, country, salary, dl ));

    }
    @PostMapping("/savetwo")
    public String saveToBaseTwo (@RequestParam Long id) {

        return null;
    }

    private Long id;

    private String name;

    private String cell;

    private String country;

    private int salary;

    private String dl;
}
