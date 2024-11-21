package Car.impl;

public class ElectricCar extends Car{

    private final double avgMPCharge;
    private final int batterySize;

    public ElectricCar(String description, double avgMPCharge, int batterySize) {
        super(description);
        this.avgMPCharge = avgMPCharge;
        this.batterySize = batterySize;
    }


    @Override
    public void drive() {
        System.out.println(".......");

    }

    @Override
    public void startEngine() {
        System.out.println("Is it on? I cant hear anything?");
    }

    @Override
    public void runEngine() {
        System.out.println("Silence......(Electric Car)");
    }

    public double getAvgMPCharge() {
        return avgMPCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }

    @Override
    public String toString() {
        return "ElectricCar{ description= " + this.getDescription()+
                ", avgMPCharge=" + avgMPCharge +
                ", batterySize=" + batterySize +
                '}';
    }
}
