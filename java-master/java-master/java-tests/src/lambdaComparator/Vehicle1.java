package lambdaComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Vehicle1 {


    int engineCapacity;
    int noOfGears;
    String type;

    Vehicle1(int engineCapacity, int noOfGears, String type) {
        this.engineCapacity = engineCapacity;
        this.noOfGears = noOfGears;
        this.type = type;
    }

    public static void main(String[] args) {
        ArrayList<Vehicle1> arrVehicle1 = new ArrayList<Vehicle1>();

        arrVehicle1.add(new Vehicle1(300,4,"Bike"));
        arrVehicle1.add(new Vehicle1(200,4,"Bike"));
        arrVehicle1.add(new Vehicle1(800,5,"Auto"));
        arrVehicle1.add(new Vehicle1(1000,5,"Car"));

        Collections.sort(arrVehicle1,(p1, p2) -> {return (p1.noOfGears<p2.noOfGears) ? -1 : (p1.noOfGears>p2.noOfGears) ? 1 : 0 ;});

        for (Vehicle1 v : arrVehicle1) {
            System.out.println(v.noOfGears + " " + v.type + " " +v.engineCapacity);
        }


    }
}
