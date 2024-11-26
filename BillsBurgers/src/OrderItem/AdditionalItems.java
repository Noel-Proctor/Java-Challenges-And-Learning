package OrderItem;

import java.util.Arrays;

public class AdditionalItems extends OrderItem{

    public AdditionalItems(){
        this.selectableItems.addAll(Arrays.asList("Cheese Sticks", "Nachos", "Ice Cream",
                "Coleslaw", "Sweet Corn", "Fries", "Carrot Sticks"));
        this.ItemType = "Additional Items";
    }
}
