package Order.impl;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    private final OrderType orderType = new OrderType();
    private ArrayList<Object> orderList = new ArrayList();


    /**
     * Adds an idem to an order
     */
    public void addItem(){

    }







    public void setOrderType() {
        this.orderType.setOrderTypeType();
    }

    public String getOrderType() {
        return orderType.getOrderType();
    }

    /**
     * Order Type Class to manage order types
     */
    private class OrderType {

        private String orderType;
        private final String[] options = {"Sit In", "Take Away"};


        public String getOrderType() {
            return orderType;
        }

        /**
         * Set order type
         */
        public void setOrderTypeType() {

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