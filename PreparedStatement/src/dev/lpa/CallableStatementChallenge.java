package dev.lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;


record OrderDetail2(int orderDetailId, String itemDescription, int qty) {

    public OrderDetail2(String itemDescription, int qty) {
        this(-1, itemDescription, qty);
    }

    public String toJSON() {
        return new StringJoiner(",", "{", "}").add("\"itemDescription\":\"" + itemDescription + "\"")
                .add("\"qty\":" + qty).toString();
    }
}

record Order2(int orderId, String dateString, List<OrderDetail2> details) {

    public Order2(String dateString) {
        this(-1, dateString, new ArrayList<>());
    }

    public void addDetail(String itemDescription, int qty) {
        OrderDetail2 item = new OrderDetail2(itemDescription, qty);
        details.add(item);
    }

    public String getDetailsJSON() {
        StringJoiner jsonString = new StringJoiner(",", "[", "]");
        details.forEach((d) -> jsonString.add(d.toJSON()));
        return jsonString.toString();
    }
}


public class CallableStatementChallenge {

    public static void main(String[] args) {

        var datasource = new MysqlDataSource();

        datasource.setServerName("localhost");
        datasource.setPort(3306);
        datasource.setDatabaseName("storefront");
        List<Order2> orders = readOrderData();

        try {
            datasource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try (Connection conn = datasource.getConnection(
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS")
        )) {


//            String sql = "SELECT * from storefront.order inner join order_details on order.order_id = order_details.Order_id";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            System.out.println("Connection successful");
//
//            var meta = rs.getMetaData();
//            System.out.println("===================");
//
//            for (int i = 1; i <= meta.getColumnCount(); i++) {
//                System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
//
//            }
//            System.out.println();
//
//            while (rs.next()) {
//                for (int i = 1; i <= meta.getColumnCount(); i++) {
//                    System.out.printf("%-15s", rs.getString(i));
//
//                }
//                System.out.println();
//            }


            CallableStatement cs = conn.prepareCall(
                    "{ CALL storefront.addOrder(?,?,?,?) }");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

            orders.forEach( (o) -> {
//                System.out.println(o.getDetailsJSON());
                try{

                    LocalDateTime localDateTime = LocalDateTime.parse(o.dateString(), formatter);
                    Timestamp timestamp = Timestamp.valueOf(localDateTime);

                    cs.setTimestamp(1,timestamp);
                    cs.setString(2, o.getDetailsJSON());
                    cs.registerOutParameter(3, Types.INTEGER);
                    cs.registerOutParameter(4, Types.INTEGER);

                    cs.execute();
                    System.out.printf("%d number of records inserted for %d %n", cs.getInt(4), cs.getInt(3));


                } catch (Exception e) {
                    System.out.println("There was a problem");
                    e.printStackTrace();
                }


            });

        } catch (SQLException e) {
            System.out.println("Connection unsuccessful");
            e.printStackTrace();
        }
    }


    private static List<Order2> readOrderData() {

        List<Order2> orders = new ArrayList<>();

        try (Scanner scanner = new Scanner(Path.of("Orders.csv"))) {
            scanner.useDelimiter("[,\\n]");
            var list = scanner.tokens().map(String::trim).toList();

            for (int i = 0; i < list.size(); i++) {
                String value = list.get(i);
                if (value.equals("order")) {

                    var date = list.get(++i);
                    orders.add(new Order2(date));

                } else if (value.equals("item")) {
                    var qty = Integer.parseInt(list.get(++i));
                    var description = list.get(++i);
                    Order2 order2 = orders.get(orders.size() - 1);
                    order2.addDetail(description, qty);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return orders;
    }

}

