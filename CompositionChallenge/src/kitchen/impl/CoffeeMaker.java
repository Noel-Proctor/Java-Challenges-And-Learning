package kitchen.impl;

public class CoffeeMaker extends KitchenAppliance {

    public void brewCoffee(){
        if (this.isHasWorkToDo()){
            System.out.println("Making Coffee...");
        }
    }


}
