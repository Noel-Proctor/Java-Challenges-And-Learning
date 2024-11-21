package kitchen.impl;

public class SmartKitchen {

    private CoffeeMaker coffeeMaker;
    private DishWasher dishWasher;
    private Refrigerator refrigerator;

    public SmartKitchen(CoffeeMaker coffeeMaker, DishWasher dishWasher, Refrigerator refrigerator) {
        this.coffeeMaker = coffeeMaker;
        this.dishWasher = dishWasher;
        this.refrigerator = refrigerator;
    }

    public void addWater(){
        this.coffeeMaker.setHasWorkToDo(true);

    }


    public void pourMilk(){
        this.refrigerator.setHasWorkToDo(true);
    }

    public void loadDishwasher(){
        this.dishWasher.setHasWorkToDo(true);

    }

    public void setKitchenState(boolean orderFood, boolean doDishes, boolean makeCoffee){
        this.refrigerator.setHasWorkToDo(orderFood);
        this.dishWasher.setHasWorkToDo(doDishes);
        this.coffeeMaker.setHasWorkToDo(makeCoffee);
    }

    public void doKitchenWork(){
        coffeeMaker.brewCoffee();
        refrigerator.orderFood();
        dishWasher.doDishes();

    }




}
