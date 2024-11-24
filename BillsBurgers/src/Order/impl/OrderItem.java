package Order.impl;

import Order.impl.OrderItem.AdditionalItem;
import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * An Individual Order Item that is added to an order.
 */
public class OrderItem {

    private MainMeal main = new MainMeal();
    private SideOrder = new SideOrder();
    private Drink = new Drink();
    private ArrayList<AdditionalItem> additionalItems = ArrayList<AdditionalItem>();


    private class MainMeal extends SantasLittleHelpers{


    }

    private class SideOrder extends SantasLittleHelpers{
        private ArrayList<String> items = new ArrayList<>(Arrays.asList( "Onion Rings", "Mashed Potatoes with Gravy", "Mac and Cheese",
                "Fried Pickles", "Chili", "Fries", "Baked Beans", "Sweet Potato Fries",
                "Coleslaw", "Corn on the Cob" ));

        public addAddionalItem(String item){
            this.items.add(item);
        }

    }

    private class Drinks extends SantasLittleHelpers{
        private ArrayList<String> items = new ArrayList<>(Arrays.asList( "Coca-Cola", "Sprite", "Lemonade",
                "Chocolate Milkshake", "Iced Tea", "Root Beer", "Fanta", "Mountain Dew", "Pepsi", "Dr Pepper"));

        public addAddionalItem(String item){
            this.items.add(item);
        }
    }


    private class AdditionalItem extends SantasLittleHelpers{

        private ArrayList<String> itemsSelected = new ArrayList<String>();

        private ArrayList<String> selectableItems = new
                ArrayList<>(Arrays.asList( "Cheese Sticks", "Nachos", "Ice Cream",
                "Coleslaw", "Sweet Corn", "Fries", "Carrot Sticks" ));

        public addAddionalItem(String item){
            this.selectableItems.add(item);
        }

        public addAdditionalItemToOrder(){
            this.itemsSelected.add(selectItem(this.selectableItems));
        }

        public printItemsSelected(){

            StringBuilder sb = new StringBuilder();
            sb.append("Additional Items: \n");
            for (int i = 0; i <itemsSelected.size() ; i++) {
                String s = "["+i+1+"] "+itemsSelected.get(i)
                sb.append(s);
            }

            
        }

        }









}

