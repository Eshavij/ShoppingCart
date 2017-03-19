package Client;



import DAO.OrderDaoImpl;

import Domain.Order;
import Service.BillService;
import Service.OrderService;
import java.util.List;

/**
 * Created by esha on 2/20/17.
 */
public class OrderClient {
    public OrderClient() throws Exception {
    }

    public static void main(String[] args) throws Exception {

        OrderService orderService = new OrderService();
        orderService.makeOrder();
        BillService billService=new BillService();
        billService.billgenerate(2);
    }

    OrderDaoImpl orderDao = new OrderDaoImpl();

    public OrderDaoImpl getOrderDao() {
        return null;
    }

    List<Order> orders = CSVFileReader.readOrderCSV();

    OrderService orderService = new OrderService();
    }









