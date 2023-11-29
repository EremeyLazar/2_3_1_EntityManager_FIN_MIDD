package model;


//Нет компонента и связки. С компонентом все ломается.
//Валидатор не работает.


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {


    private int id;

    @NotEmpty(message = "name should be visible")
    @Size (min=2, max = 12, message = "name should be valid")
    private String name;

    @Min(value = 0, message = "cell# should be real")
    @NotEmpty(message = "name should be visible")
    private String cell;

    @NotEmpty(message = "Country should be visible")
    private String country;

    @Min(value = 10, message = "no volunteers allowed here")
    private int salary;

    @NotEmpty(message = "Country should be visible")
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
