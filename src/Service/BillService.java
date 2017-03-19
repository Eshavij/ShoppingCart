package Service;
import DAO.DaoBill;

import java.io.*;
import java.util.*;

import Domain.*;
/**
 * Created by esha on 3/6/17.
 */
public class BillService {
    public void billgenerate(int orderId) throws Exception{

        File file = new File("resources/BillG.csv");
        DaoBill daoBill = new DaoBill();
        file.createNewFile();

        String productname="";
        int price=0,productquantity=0,productprice=0;

        ProductService servicesProduct = new ProductService();

        ArrayList<Integer> arrayList = daoBill.Billdetail(2);


        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Order Id: "+ orderId+"\n");

        String row = "NAME,QUANTITY,INITIALPRICE,TOTAL";
        fileWriter.write(row+ "\n");
        int quantity=0, productid=0;
        int grossTotal=0;

        Product product = new Product();
        for(int i=0;i<arrayList.size();i+=2)
        {
            quantity = arrayList.get(i);
            productid = arrayList.get(i + 1);
            System.out.println(quantity + "" + productid);
            product = servicesProduct.getById(productid);

            productprice = product.getUnitPrice();
            productname = product.getProductCode();

            int total = productprice * quantity;
            grossTotal = grossTotal + total;
            row = ""+ productname + "," + quantity + "," + productprice + "," + total;

            fileWriter.write(row);
            fileWriter.write("\n");
        }
        fileWriter.write("Total Price " + ","+","+"," + grossTotal);
        fileWriter.flush();
        fileWriter.close();
    }
}
