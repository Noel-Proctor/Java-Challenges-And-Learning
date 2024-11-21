package kitchen.impl;

public class DishWasher extends KitchenAppliance {

    public void doDishes(){

        if (this.isHasWorkToDo()){
            System.out.println("Doing Dishes...");
        }


    }
}
