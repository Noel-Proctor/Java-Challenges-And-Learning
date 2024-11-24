import Order.impl.Order;

public class BurgerShop {

    public static void main(String[] args) {

        Order o1 = new Order();
        o1.setOrderType();

        System.out.println();
        System.out.println("OrderType has been set");
        System.out.println("Order Type: "+o1.getOrderType());
        System.out.println();
        System.out.println("-----------");
        System.out.println();
        System.out.println("Resetting Order Type");
        System.out.println();
        System.out.println("-----------");

        o1.setOrderType();
        System.out.println();
        System.out.println("OrderType has been reset");
        System.out.println("Order Type: "+o1.getOrderType());






    }
}
