package DAO;

import Domain.OrderDetails;
import java.util.List;

/**
 * Created by esha on 2/21/17.
 */
public interface OrderDetailsInterface {

        public void save(OrderDetails orderDetails) throws Exception;

        public OrderDetails getOrderDetailsForId(int odId)throws Exception;

        public List<OrderDetails> getAllOrderDetails()throws Exception;
    }

