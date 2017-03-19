package Client;

import DAO.OrderDaoImpl;
import DAO.ProductDaoImpl;
import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;
import Service.OrderDetailsService;
import java.util.List;

/**
 * Created by esha on 2/20/17.
 */
public class OrderDetailsClient {
    public static void main(String[] args) throws Exception {


        OrderDaoImpl odDao = new OrderDaoImpl();
        ProductDaoImpl pdDao = new ProductDaoImpl();
        Order order = odDao.getOrderForOrderId(4);
        Product product = pdDao.getProductForProductId(2);
        OrderDetails od = new OrderDetails(product, 2, product.getUnitPrice(), 2 * product.getUnitPrice(), order);

        OrderDetailsService orderDetailsService = new OrderDetailsService();
        orderDetailsService.generateOrderDetailsCSV();




        OrderDetailsService ods = new OrderDetailsService();
        List<OrderDetails> orderDetailsList = null;
        try {
            ods.makeOrderDetail(14, 2, 5);
            orderDetailsList = ods.getAllOrderDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ods.generateOrderDetailsCSV();
    }
    public void placeOrderDetails(int orderId){

    }
}
