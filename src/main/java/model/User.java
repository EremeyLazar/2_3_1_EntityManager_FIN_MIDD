package model;

public class User {


    private int id;
    private String name;
    private String cell;
    private String sex;
    private int salary;
    private String dl;

    public User() {
    }

    public User(int id, String name, String cell, String sex, int salary, String dl) {
        this.id = id;
        this.name = name;
        this.cell = cell;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
                "sex - " + sex + " | " +
                "salary - " + salary + " | " +
                "driver's licence number is " + dl;
    }
}
