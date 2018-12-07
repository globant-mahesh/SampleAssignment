package FunctInterface;

@FunctionalInterface  
interface sayable{  
    void say(String msg);
    
    static void sayLouder(String msg){    
        System.out.println(msg);    
    }  
}  