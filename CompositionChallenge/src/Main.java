import kitchen.impl.CoffeeMaker;
import kitchen.impl.DishWasher;
import kitchen.impl.Refrigerator;
import kitchen.impl.SmartKitchen;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Refrigerator refrigerator = new Refrigerator();
        DishWasher dishwasher = new DishWasher();

        SmartKitchen smartKitchen = new SmartKitchen(coffeeMaker, dishwasher, refrigerator);

        smartKitchen.setKitchenState(true,true,true);
        smartKitchen.doKitchenWork();

        System.out.println("Resetting kithen state");
        smartKitchen.setKitchenState(true, false,false);
        smartKitchen.doKitchenWork();

    }
}