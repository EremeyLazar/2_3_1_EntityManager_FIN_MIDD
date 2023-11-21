package model;

public class Cars {

    private String owner;
    private String model;
    private int number;

    public Cars() {
    }

    public Cars(String owner, String model, int number) {
        this.owner = owner;
        this.model = model;
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car's owner is " + owner + ", the model is " + model + ", the number is " + number + "\n";
    }
}
