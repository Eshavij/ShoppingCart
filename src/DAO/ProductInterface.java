package DAO;

import Domain.Product;
import java.util.List;

/**
 * Created by esha on 2/21/17.
 */
public interface ProductInterface {
        void save(Product product)throws Exception;

        Product getProductForProductId(int productId);

        Product updateProductInfo(int productId, Product product)throws Exception;
        public List<Product> getAllproduct();
}
