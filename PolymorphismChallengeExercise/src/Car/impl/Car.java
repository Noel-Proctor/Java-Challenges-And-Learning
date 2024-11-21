package Car.impl;

public class Car implements ICar{

    private String description;

    public Car(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void startEngine() {
        System.out.println("Engine goes vrooom.");

    }

    @Override
    public void drive() {
        System.out.println("Get us outta here now...");

    }

    @Override
    public void runEngine() {
        System.out.println("vrrooooommmm.... vrroooommm.. vroommm");
    }


}
