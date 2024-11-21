package dev.lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


record OrderDetail(int orderDetailId, String itemDescription, int qty){

    public OrderDetail(String itemDescription, int qty){
        this(-1, itemDescription, qty);
    }
}

record Order(int orderId, String dateString, List<OrderDetail> details){

    public Order(String dateString){
        this(-1, dateString, new ArrayList<>());
    }

    public void addDetail(String itemDescription, int qty){
        OrderDetail item = new OrderDetail(itemDescription, qty);
        details.add(item);
    }



}

public class Challenge2 {

    public static void main(String[] args) {

        var dataSource = new MysqlDataSource();

        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");
        List<Order> orders = readData();

        try {
            dataSource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection conn = dataSource.getConnection(
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"))
        ) {

            addOrders(conn, orders);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static List<Order> readData(){
        List<Order> vals = new ArrayList<>();

        try(Scanner scanner = new Scanner(Path.of("Orders.csv"))){
            scanner.useDelimiter("[,\\n]");
            var list = scanner.tokens().map(String::trim).toList();

            for (int i =0; i<list.size(); i++){
                String value = list.get(i);
                if(value.equals("order")){

                    var date = list.get(++i);
                    vals.add(new Order(date));

                } else if (value.equals("item")) {
                    var qty = Integer.parseInt(list.get(++i));
                    var description = list.get(++i);
                    Order order = vals.get(vals.size()-1);
                    order.addDetail(description, qty);
                }

            }
            vals.forEach(System.out::println);

        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return vals;


    }


    private static void addOrder(Connection conn, PreparedStatement psOrder,
                                 PreparedStatement psDetail, Order order) throws SQLException {


            try{
                conn.setAutoCommit(false);

                int orderID = -1;
                psOrder.setString(1, order.dateString());
                if (psOrder.executeUpdate()==1){
                    var rs = psOrder.getGeneratedKeys();
                    if (rs.next()){
                        orderID = rs.getInt(1);
                        System.out.println("orderId: "+orderID);

                        if (orderID >-1){
                            psDetail.setInt(1, orderID);
                            for (OrderDetail od : order.details()){
                                psDetail.setString(2, od.itemDescription());
                                psDetail.setInt(3, od.qty());
                                psDetail.addBatch();
                            }
                            int [] data = psDetail.executeBatch();
                            int rowsInserted = Arrays.stream(data).sum();
                            if(rowsInserted!= order.details().size()){
                                throw new SQLException("Inserts don't match");
                            }
                        }
                    }
                }

                conn.commit();

            }catch(SQLException e){
                conn.rollback();
                throw e;
            } finally{
                conn.setAutoCommit(true);
            }
        }


    private static void addOrders(Connection conn, List<Order> orders) {
        String insertOrder = "INSERT INTO storefront.order (order_date) VALUES (?)";
        String insertDetail = "INSERT INTO storefront.order_details (order_id, item_description, quantity) values (?,?,?)";

        try (
                PreparedStatement psOrder = conn.prepareStatement(insertOrder,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement psDetail = conn.prepareStatement(insertDetail,
                        PreparedStatement.RETURN_GENERATED_KEYS);
        ) {


            orders.forEach((o) -> {

                try {
                    addOrder(conn, psOrder, psDetail, o);
                } catch (SQLException e) {
                    System.err.printf("%d (%s) %s%n", e.getErrorCode(), e.getSQLState(), e.getMessage());
                    System.err.println("Problem: " + psOrder);
                    System.err.println("Order: " + o);
                }
            });


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}



