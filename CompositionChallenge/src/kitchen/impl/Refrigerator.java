package kitchen.impl;

public class Refrigerator extends KitchenAppliance {

    public void orderFood(){

        if (this.isHasWorkToDo()){
            System.out.println("Ordering Food...");
        }


    }



}
