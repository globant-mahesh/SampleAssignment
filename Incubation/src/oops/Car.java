package oops;
// Abstraction
public class Car implements Vehicle {
//Encapsulation
    private String manufacturer;
    private String model;
    private int noOfGears;

    Car(String manufacturer, String model, int noOfGears) {

        this.manufacturer = manufacturer;
        this.model =model;
        this.noOfGears = noOfGears;

    }

    @Override
    public String companyMade() {
        return this.manufacturer;
    }
    @Override
    public void noOfWheels() {
        System.out.println("Car has 4 Wheels ");
    }

    @Override
    public int getnoOfGears() {
        return this.noOfGears;
    }
}
