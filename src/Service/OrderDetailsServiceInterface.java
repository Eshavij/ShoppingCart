package Service;

import Domain.OrderDetails;
import java.util.List;

/**
 * Created by esha on 3/6/17.
 */
public interface OrderDetailsServiceInterface {
    public List<OrderDetails> getAllorderDetails();
    public void  getOrderDetail(int orderDetailId);
    public void makeOrderDetail(int productId, int orderId,int qtyPurchased);

}
