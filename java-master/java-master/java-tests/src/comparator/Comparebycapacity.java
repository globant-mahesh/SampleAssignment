package comparator;

import java.util.Comparator;

public class Comparebycapacity implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        if(v1.engineCapacity == v2.engineCapacity)
            return 0;
        else if(v1.engineCapacity<v2.engineCapacity)
            return -1;
        else
            return 1;
    }
}


