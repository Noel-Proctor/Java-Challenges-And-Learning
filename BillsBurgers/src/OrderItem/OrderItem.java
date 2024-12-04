package OrderItem;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * An Individual Order Item that is added to an order.
 */
public class OrderItem {

    private ArrayList<String> itemsSelected = new ArrayList<String>();
    protected ArrayList<String> selectableItems = new ArrayList<String>();
    protected String ItemType;

    public String getItemType() {
        return ItemType;
    }

    public ArrayList<String> getItemsSelected() {
        return itemsSelected;
    }

    protected void addAddionalItem(String item) {
        this.selectableItems.add(item);
    }

    public void addAdditionalItemToOrder() {

        this.itemsSelected.add(selectItem());

    }

    public void printItemsSelected() {
        StringBuilder sb = new StringBuilder();
        String x = this.ItemType+": \n";
        sb.append(x);
        for (int i = 0; i < itemsSelected.size(); i++) {
            String s = "\t\t[" + i + 1 + "] " + itemsSelected.get(i);
            sb.append(s);
        }
        System.out.println(sb);
    }

    private String selectItem() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Please select from the following options:\n ");

            for (int i = 0; i < this.selectableItems.size(); i++) {
                int count = i+1;
                String x = "Press " + count + " for "+this.selectableItems.get(i)+".\n";
                sb.append(x);
            }

            System.out.println(sb.toString());

            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            while (input < 0 || input > this.selectableItems.size()) {
                System.out.println("Invalid selection. Please choose an valid option");
                System.out.println();
                System.out.println(sb.toString());
                input = sc.nextInt();
            }
            return this.selectableItems.get(input - 1);
        } catch (Exception e) {
            System.out.println("Ooops. Something went wrong.");
            System.out.println("Error location: OrderItem.SelectItem");

        }
        return "-1";
    }
}

