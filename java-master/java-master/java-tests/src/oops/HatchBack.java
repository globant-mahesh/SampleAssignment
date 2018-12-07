package oops;
//Inheritance
class HatchBack extends Car {
    //Constructor to set the properties of object
    HatchBack(String manufacturer, String model, int noOfGears){
        super(manufacturer,model,noOfGears);
    }

    String getCompany() {
        System.out.println("This is hatchback car of "  +companyMade());
        return null;
    }

    // Polymorphism
    void bootSpace() {
        System.out.println("Bootspace for hatchback car is 20 Litres");
    }

    void bootSpace(String model) {
        System.out.println("Bootspace for hatchback car with model "+model+ " is 25 Litres");
    }
}
