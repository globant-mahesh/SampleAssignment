package staticreference;

public interface Maths {
    void add(int a, int b);
 }

class Implementation implements Maths {
     public void add(int a, int b) {
         System.out.println("Addition of two numbers is " +(a+b));
    }

    static void multiply(int a, int b) {
        System.out.println("Multiplication of two numbers is " +(a*b));
    }

    public static void main(String[] args) {
        Implementation impl = new Implementation();
        impl.add(20,30);
        // Referencing static method
        Maths mat = Implementation::multiply;
        mat.add(10,4);

    }
}
