package OrderItem;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * An Individual Order Item that is added to an order.
 */
public abstract class OrderItem {

    private ArrayList<String> itemsSelected = new ArrayList<String>();
    protected ArrayList<String> selectableItems = new ArrayList<String>();
    protected String ItemType;

    protected void addAddionalItem(String item) {
        this.selectableItems.add(item);
    }

    protected void addAdditionalItemToOrder() {
        this.itemsSelected.add(selectItem(this.selectableItems));

    }

    protected void printItemsSelected() {
        StringBuilder sb = new StringBuilder();
        String x = this.ItemType+": \n";
        sb.append(x);
        for (int i = 0; i < itemsSelected.size(); i++) {
            String s = "[" + i + 1 + "] " + itemsSelected.get(i);
            sb.append(s);
        }
        System.out.println(sb);
    }


    private String selectItem(ArrayList<String> items) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Please select from the following options:\n ");

            for (int i = 0; i <= items.size(); i++) {
                String x = "Press " + i + 1 + " for "+items.get(i)+".\n";
                sb.append(x);
            }

            System.out.println(sb.toString());

            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            while (input < 0 || input > items.size()) {
                System.out.println("Invalid selection. Please choose an valid option");
                System.out.println();
                System.out.println(sb.toString());
                input = sc.nextInt();
            }
            return items.get(input - 1);
        } catch (Exception e) {
            System.out.println("Ooops. Something went wrong.");

        }
        return "-1";
    }
}

