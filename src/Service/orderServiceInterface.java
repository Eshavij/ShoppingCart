package Service;

import java.util.List;

/**
 * Created by esha on 3/5/17.
 */
public interface orderServiceInterface {
     public void getOrder();
    public void makeOrder(int userId,String status);
    public List<OrderService> allorders();

    public default void getAllOrder() {

    }
}
