package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListLearning {  
    @SuppressWarnings("unchecked")  
    public static void main(String[] args) {  
  
        List<SmartPhone> phoneList = new ArrayList<>();  
        SmartPhone ph1 = new SmartPhone("Apple", "6s", 50000, 10);  
        SmartPhone ph2 = new SmartPhone("lg", "pro2", 40000, 9);  
        SmartPhone ph3 = new SmartPhone("MI", "3s", 10000, 6);  
        SmartPhone ph4 = new SmartPhone("Letv", "le2", 12000, 7);  
  
        phoneList.add(ph1);  
        phoneList.add(ph2);  
        phoneList.add(ph3);  
        phoneList.add(ph4);  
        System.out.println("Actual List");  
        System.out.println(phoneList);  
        System.out.println("Sorting the list as comparator");  
        Collections.sort(phoneList, new RatingComparator());  
  
        System.out.println(phoneList);  
        System.out.println("Reversing the Comparator sorting");  
        Comparator<SmartPhone> cmp = Collections.reverseOrder(new RatingComparator());  
  
        Collections.sort(phoneList, cmp);  
        System.out.println("Printing the reverse list");  
        System.out.println(phoneList);  
    }  
  
}  