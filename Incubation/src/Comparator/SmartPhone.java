package Comparator;
import java.util.Comparator;  
public class SmartPhone {  
    String brand;  
    String model;  
    int price;  
    int rating;  
    SmartPhone(String brand,String model,int price, int rating){  
        this.brand = brand;  
        this.model = model;  
        this.price = price;  
        this.rating = rating;  
          
    }  
    public String getBrand() {  
        return brand;  
    }  
    public void setBrand(String brand) {  
        this.brand = brand;  
    }  
    public String getModel() {  
        return model;  
    }  
    public void setModel(String model) {  
        this.model = model;  
    }  
    public int getPrice() {  
        return price;  
    }  
    public void  setPrice(int price) {  
        this.price = price;  
    }  
    public int getRating() {  
        return rating;  
    }  
    public void setRating(int rating) {  
        this.rating = rating;  
    }  
    public String toString() {  
        return"SmartPhone [brand=" + brand + ", model=" + model + ", price=" + price + ", rating=" + rating + "]";  
    }  
    public int compareTo(SmartPhone sp) {  
        return this.price - sp.price;  
  
    }  
}  
class RatingComparator implements Comparator<SmartPhone> {  
    @Override  
    public int compare(SmartPhone obj1, SmartPhone obj2) {  
        return (obj1.rating<obj2.rating) ? -1 : (obj1.rating>obj2.rating) ? 1 : 0;  
    }  
}  