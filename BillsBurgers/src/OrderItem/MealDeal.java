package OrderItem;

public class MealDeal{

    private Drink drink = new Drink();



    private final String orderType = "Meal Deal";
    private MainItem main = new MainItem();
    private SideOrder sideOrder = new SideOrder();

    public MealDeal(){
        main.addAdditionalItemToOrder();
        sideOrder.addAdditionalItemToOrder();
        drink.addAdditionalItemToOrder();
    }

    public String getOrderType() {
        return orderType;
    }

    public Drink getDrink() {
        return drink;
    }

    public SideOrder getSideOrder() {
        return sideOrder;
    }

    public MainItem getMain() {
        return main;
    }

}
