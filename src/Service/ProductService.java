package Service;

import DAO.ProductDaoImpl;
import Domain.Product;

import java.util.List;

/**
 * Created by esha on 2/21/17.
 */





public class ProductService implements ProductServiceInterface{

    public void insertproduct(Product product) {

        ProductDaoImpl productDao = new ProductDaoImpl();

        try {
            productDao.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Product> allProduct() {
        ProductDaoImpl productDao=new ProductDaoImpl();
        return productDao.getAllproduct();
    }


    public Product getById(int id) throws Exception{
        ProductDaoImpl productDao = new ProductDaoImpl();
        return productDao.getById(id);
    }


    public void getProduct(int productId) {
        ProductDaoImpl productDao = new ProductDaoImpl();
        productDao.getproduct(productId);

    }


    public void getAllProduct(int productid) {
        ProductDaoImpl productDao=new ProductDaoImpl();
        productDao.getAllproduct();

    }
    public void updateProductInfo(){
        ProductDaoImpl product=new ProductDaoImpl();

    }






    }





