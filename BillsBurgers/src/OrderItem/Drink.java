package OrderItem;

import java.util.Arrays;

public class Drink extends  OrderItem{

    public Drink(){
        this.selectableItems.addAll(Arrays.asList("Coca-Cola", "Sprite", "Lemonade",
                "Chocolate Milkshake", "Iced Tea", "Root Beer", "Fanta", "Mountain Dew", "Pepsi", "Dr Pepper"));
        this.ItemType = "Drinks";

    }
}
