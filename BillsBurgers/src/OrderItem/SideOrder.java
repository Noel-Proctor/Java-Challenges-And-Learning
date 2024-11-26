package OrderItem;

import java.util.Arrays;

public class SideOrder extends OrderItem{

    public SideOrder(){
        this.selectableItems.addAll(Arrays.asList("Onion Rings", "Mashed Potatoes with Gravy", "Mac and Cheese",
                "Fried Pickles", "Chili", "Fries", "Baked Beans", "Sweet Potato Fries",
                "Coleslaw", "Corn on the Cob"));
        this.ItemType = "Side";
    }
}
