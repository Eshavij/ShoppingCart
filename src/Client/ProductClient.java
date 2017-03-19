package Client;

import DAO.ProductDaoImpl;

import Domain.Product;
import Service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by esha on 2/20/17.
 */


public class ProductClient {

    public static void main(String[] args) throws SQLException, Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 insert \n 2 Update");
        int choice = sc.nextInt();
        if (choice == 1) {

            try {
                List<Product> products = CSVFileReader.readProductCSV();

                ProductService productService = new ProductService();

                for (Product product : products) {

                    System.out.println("1");
                    productService.insertproduct(product);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        if (choice == 2) {
            ProductDaoImpl pro = new ProductDaoImpl();

            Product prod = pro.getproduct(1);



            try

            {
                ProductDaoImpl pro1 = new ProductDaoImpl();
                Product prod1 = null;
                Product prod2 = pro1.updateProductInfo(prod.getProductId(), prod1);

            } catch (Exception e) {
                e.printStackTrace();


            }

        }

    }
}





