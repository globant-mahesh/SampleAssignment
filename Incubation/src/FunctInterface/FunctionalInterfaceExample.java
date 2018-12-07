package FunctInterface;

public class FunctionalInterfaceExample implements sayable{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
        fie.say("Hello there");  
        sayable.sayLouder("static");
    }  
}  

