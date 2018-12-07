package oops;

public class Sedan extends Car {

    //Constructor to set the properties of object
    Sedan(String manufacturer, String model, int noOfGears){
        super(manufacturer,model,noOfGears);
    }

    void bootspace() {
        System.out.println("Bootspace of Sedan is 35 Litres");
    }

}
