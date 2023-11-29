package model;

import org.springframework.stereotype.Component;


public class User {


    private int id;
    private String name;
    private String cell;
    private String country;
    private int salary;
    private String dl;

    public User() {
    }

    public User(int id, String name, String cell, String country, int salary, String dl) {
        this.id = id;
        this.name = name;
        this.cell = cell;
        this.country = country;
        this.salary = salary;
        this.dl = dl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    @Override
    public String toString() {
        return  "id " + id + " | " +
                "name - " + name + " | " +
                "cell: " + cell + " | " +
                "country of residence - " + country + " | " +
                "salary - " + salary + " | " +
                "driver's licence number is " + dl;
    }
}
