package Car.impl;

public class HybridCar extends Car {

    private final double avgMPG;
    private final double batterySize;
    private final int cylinders;

    public HybridCar(String description, int cylinders, double batterySize, double avgMPG) {
        super(description);
        this.cylinders = cylinders;
        this.batterySize = batterySize;
        this.avgMPG = avgMPG;
    }


    @Override
    public void drive() {
        super.drive();
        System.out.println("Hybrid Car Drives.");
    }

    @Override
    public void startEngine() {
        System.out.println("Im bored now. Hybrid Car Starts");
    }

    @Override
    public void runEngine() {
        super.runEngine();
        System.out.println("Hybrid Car runsEngine");
    }


    public double getBatterySize() {
        return batterySize;
    }

    public double getAvgMPG() {
        return avgMPG;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public String toString() {
        return "HybridCar{ description= " + this.getDescription()+
                ", avgMPG=" + avgMPG +
                ", batterySize=" + batterySize +
                ", cylinders=" + cylinders +
                '}';
    }

}
