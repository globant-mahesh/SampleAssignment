import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapSample {

    public static void main(String[] args ) {
        Map<Integer, String> map = new HashMap<Integer, String>();


        map.put(150,"Pune");
        map.put(200,"Mumbai");
        map.put(100,"Nagpur");
        map.put(103,"Nashik");
        
    map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


    }


}
