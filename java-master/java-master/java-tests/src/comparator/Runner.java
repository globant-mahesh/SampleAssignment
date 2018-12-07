package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Runner {

    public static void main(String[] args) {
        ArrayList<Vehicle> arrVehicle = new ArrayList<Vehicle>();

        arrVehicle.add(new Vehicle(300,4,"Bike"));
        arrVehicle.add(new Vehicle(200,4,"Bike"));
        arrVehicle.add(new Vehicle(800,5,"Auto"));
        arrVehicle.add(new Vehicle(1000,5,"Car"));

        //Comparing the vehicles by engine capacity and sorting them
        System.out.println("Sorted vehicles by engine capacity (Using For Loop) - ");
        Collections.sort(arrVehicle,new Comparebycapacity());
        for (int i=0;i<arrVehicle.size();i++) {
            System.out.println("Sorted Vehicles are " +arrVehicle.get(i).engineCapacity + " " +arrVehicle.get(i).noOfGears + " " +arrVehicle.get(i).type);

        }

        //Comparing the vehicles by no of gears and sorting them
        System.out.println("Sorted vehicles by no of gears (using foreach loop) - ");
        Collections.sort(arrVehicle,new Comparebygear());
        for (Object o: arrVehicle
             ) {
            Vehicle veh = (Vehicle)o;
            System.out.println("Sorted Vehicles are " + veh.noOfGears + " "+veh.type + " "+veh.engineCapacity );
        }

        //Comparing the vehicles by no of gears and sorting them
        System.out.println("Sorted vehicles by no of gears (using Iterator interface) - ");
        Iterator itr = arrVehicle.iterator();
        while (itr.hasNext()) {
            Vehicle veh = (Vehicle)itr.next();
            System.out.println("Sorted Vehicles are " + veh.noOfGears + " " +veh.type+ " "+veh.engineCapacity);
        }



    }
}
