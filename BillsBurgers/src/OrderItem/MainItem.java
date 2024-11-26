package OrderItem;

import java.util.Arrays;

public class MainItem extends OrderItem{

    public MainItem(){
        this.selectableItems.addAll(Arrays.asList("Pizza", "Hamburger", "French Fries", "Chicken Nuggets",
                "Chicken Sandwich", "Tacos", "Burgers", "Hot Dogs", "Submarine Sandwiches", "Fish and Chips"));
        this.ItemType = "Main";
    }



}
