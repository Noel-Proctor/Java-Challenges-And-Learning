package Order.impl;

import OrderItem.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private final OrderType orderType = new OrderType();
    private ArrayList<OrderItem> orderList = new ArrayList();

    /**
     * Adds an idem to an order
     */

    public void newOrder(){
        orderType.setOrderType();
        placeOrder();
    }


    private void placeOrder(){

        addItemToOrder();

        System.out.println("You current order is: ");
        printCurrentOrder();
        System.out.println("Would you like to add another item to your order? \n");
        System.out.println("Select 1 to add an additional item.");
        System.out.println("Select 2 to place your order");
        System.out.println("Select 3 to cancel your current order");

        try(Scanner sc = new Scanner(System.in)){
            int input = sc.nextInt();

            while(input <1 || input >3){
                System.out.println("Invalid choice.");
                System.out.println("Select 1 to add an additional item.");
                System.out.println("Select 2 to place your order");
                System.out.println("Select 3 to cancel your current order");
            }

            switch(input){
                case 1-> placeOrder();
                case 2-> processOrder();
                case 3-> cancelOrder();
                default -> System.out.println("Opps. Something went wrong.");

            }
        }
    }


    private void cancelOrder(){
        System.out.println("Do cancel order stuff");
    }

    private void processOrder(){
        System.out.println("Do process order stuff...");
    }


    private void addItemToOrder(){
        System.out.println("Please select the item type you wish to add to the order: \n" +
                "[1] Main \n" +
                "[2] Sides \n" +
                "[3] Drinks \n" +
                "[4] Additional Items \n\n" +
                "Please enter the number of the item type...");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        while (input<0 || input >4){
            System.out.println("You have entered an invalid options. ");
            System.out.println();
            System.out.println("Please select the item type you wish to add to the order: \n" +
                    "[1] Main \n" +
                    "[2] Sides \n" +
                    "[3] Drinks \n" +
                    "[4] Additional Items \n\n" +
                    "Please enter the number of the item type...");
            input=sc.nextInt();
        }


        OrderItem item = switch(input){
            case 1-> new MainItem();
            case 2-> new SideOrder();
            case 3-> new Drink();
            case 4-> new AdditionalItems();
            default -> new MainItem();
        };

        item.addAdditionalItemToOrder();
        orderList.add(item);

    }

    public void setOrderType() {
        this.orderType.setOrderType();
    }

    public String getOrderType() {
        return orderType.getOrderType();
    }

    public void printCurrentOrder(){
        StringBuilder sb = new StringBuilder();
        sb.append("Your current order is: \n");

        for (OrderItem item : this.orderList) {
            item.printItemsSelected();
        }
    }

    /**
     * Order Type Class to manage order types
     */
    private static class OrderType {

        private String orderType;
        private final String[] options = {"Sit In", "Take Away"};


        public String getOrderType() {
            return orderType;
        }

        /**
         * Set order type
         */
        public void setOrderType() {

            try {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < options.length ; i++) {
                    sb.append("Please select ") .append(i + 1)
                            .append(" for ")
                            .append(options[i])
                            .append(".\n");
                }

                String result = sb.toString();
                System.out.println(result);
                Scanner sc = new Scanner(System.in);

                int input = sc.nextInt();

                while(input<0 || input > options.length){
                    System.out.println("You have entered an invalid value.");
                    System.out.println(result);
                    input = sc.nextInt();
                }

                this.orderType = options[input-1];
                System.out.println("You have selected "+this.orderType);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public String[] getOptions() {
            return options;
        }
    }

}