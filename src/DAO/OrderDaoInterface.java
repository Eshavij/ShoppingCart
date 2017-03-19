package DAO;

import Domain.Order;
import java.util.List;

/**
 * Created by esha on 2/21/17.
 */
public interface OrderDaoInterface {


        public int save(Order order)throws Exception;

        public Order getOrderForOrderId(int orderId) throws Exception;

        public List<Order> getAllOrders();


    }

