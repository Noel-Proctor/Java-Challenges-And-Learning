import Car.impl.ElectricCar;
import Car.impl.HybridCar;
import Car.impl.PetrolCar;
import Car.impl.Car;

public class Main {

    public static void main(String[] args) {

        PetrolCar FordFocus = new PetrolCar("Ford Focus", 43, 4);
        Car LandRover = new PetrolCar("Land Rover", 2, 2000);
        HybridCar ToyotaAuris = new HybridCar("Toyota Auris", 56,60542, 100);
        ElectricCar Tesla = new ElectricCar("CyberTruck", 30, 10000);

        System.out.println(FordFocus.toString());
        FordFocus.startEngine();
        FordFocus.drive();
        FordFocus.runEngine();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.println(LandRover.toString());
        LandRover.startEngine();
        LandRover.drive();
        LandRover.runEngine();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.println(ToyotaAuris.toString());
        ToyotaAuris.startEngine();
        ToyotaAuris.drive();
        ToyotaAuris.runEngine();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.println(Tesla.toString());
        Tesla.startEngine();
        Tesla.drive();
        Tesla.runEngine();

    }







}
