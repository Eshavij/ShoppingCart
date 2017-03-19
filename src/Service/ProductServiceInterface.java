package Service;

import Domain.Product;
import Domain.User;
import java.util.List;

/**
 * Created by esha on 3/5/17.
 */
public interface ProductServiceInterface {
    public void insertproduct(Product product);

    public List<Product> allProduct();
    public void getProduct(int productId);
    public void getAllProduct(int productid);
    public  void updateProductInfo();
}
