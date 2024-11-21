package Car.impl;

public class PetrolCar extends Car {

    private double avgMPG;
    private int numberOfCylinders;

    public PetrolCar(String description, double avgMPG, int numberOfCylinders) {
        super(description);
        this.avgMPG = avgMPG;
        this.numberOfCylinders = numberOfCylinders;
    }

    @Override
    public void runEngine() {
        super.runEngine();
        System.out.println("Yes honey, listen to that silky smooth petrol engine.");
        System.out.println("...Darling its a 1 litre turbo calm down");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Petrol Car Turns On");

    }


    @Override
    public void drive() {
        super.drive();
        System.out.println("We just need to get petrol first.");
    }

    public void refuel(){
        System.out.println("1.45 a litre? Bloody Government.");

    }


    public double getAvgMPG() {
        return avgMPG;
    }

    public void setAvgMPG(double avgMPG) {
        this.avgMPG = avgMPG;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    @Override
    public String toString() {
        return "PetrolCar{ description= " + this.getDescription()+
                ", avgMPG=" + avgMPG +
                ", numberOfCylinders=" + numberOfCylinders +
                '}';
    }
}
