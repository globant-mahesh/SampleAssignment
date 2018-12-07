package oops;

class TestRunner {

    public static void main(String[] args) {
        Vehicle veh = new Car("Suzuki","Swift",4);
        System.out.println("Company of the car is " +veh.companyMade());
        veh.noOfWheels();

        HatchBack hatch = new HatchBack("Suzuki","Baleno",5);
        hatch.bootSpace(hatch.companyMade());
        hatch.bootSpace();
        hatch.noOfWheels();
        System.out.println("Car has " +hatch.getnoOfGears()+ " Gears");

        Sedan sed = new Sedan("Fiat","Linea",5);
        sed.bootspace();
        sed.noOfWheels();
        System.out.println("Sedan is manufactured by " +sed.companyMade());



    }
}
