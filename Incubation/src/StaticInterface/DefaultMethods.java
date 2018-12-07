package StaticInterface;
public class DefaultMethods implements Sayable{    
    public void sayMore(String msg){     // implementing abstract method    
        System.out.println(msg);    
    }    
    public static void main(String[] args) {    
        DefaultMethods dm = new DefaultMethods();    
        dm.say();                       // calling default method    
        dm.sayMore("Work is worship");      // calling abstract method    
        Sayable.sayLouder("Helloooo...");   // calling static method    
    }    
}    
