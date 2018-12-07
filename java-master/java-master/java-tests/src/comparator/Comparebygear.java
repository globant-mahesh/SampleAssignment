package comparator;

import java.util.Comparator;

public class Comparebygear implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        if(o1.noOfGears==o2.noOfGears)
            return 0;
        else if(o1.noOfGears<o2.noOfGears)
            return -1;
        else
            return 1;
    }
}
