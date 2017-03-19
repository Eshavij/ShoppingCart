package Client;

import java.sql.Timestamp;


import Domain.Order;
import Domain.Product;
import Domain.User;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by esha on 2/20/17.
 */
public class CSVFileReader{

        final static List<User> users=new ArrayList<User>();
        final static List<Product> products=new ArrayList<Product>();
        final static List<Order> order=new ArrayList<>();

        public static List<User> readUserCSV()throws Exception{
            FileInputStream fis=new FileInputStream("resources/userCsv.csv");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=br.readLine();
            System.out.println(line);
            while(line != null){
                String[] comSeperated=line.split(",");
                int id=Integer.parseInt(comSeperated[0]);
                String name=comSeperated[1];
                String address=comSeperated[2];
                String email=comSeperated[3];
                User u=new User();
                u.setUserId(id);
                u.setAddress(address);
                u.setName(name);
                u.setEmail(email);
                users.add(u);
                line=br.readLine();
            }

            return users;
        }

        public static List<Product> readProductCSV()throws Exception{
            FileInputStream fis=new FileInputStream("resources/productcsv.csv");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=br.readLine();

            while(line != null){
                String[] comSeperated=line.split(",");
                int id=Integer.parseInt(comSeperated[0]);
                String code=comSeperated[1];
                String name=comSeperated[2];
                int qty=Integer.parseInt(comSeperated[3]);
                int unitPrice=Integer.parseInt(comSeperated[4]);


                Product p=new Product();

                p.setProductCode(code);
              p.setProductName(name);
                p.setQuantity(qty);
                p.setUnitPrice(unitPrice);


                products.add(p);

                line=br.readLine();
            }
            return products;
        }
    public static List<Order> readOrderCSV()throws Exception {
        FileInputStream fis = new FileInputStream("resources/order.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        System.out.println(line);
        while (line != null) {
            String[] comSeperated = line.split(",");
            int orderid = Integer.parseInt(comSeperated[0]);
            String orderuserid = comSeperated[1];
            Date createddate = new Date(comSeperated[2]);
            String orderstatus = (comSeperated[3]);
            Order o = new Order();
            o.setOrderId(orderid);
            o.setUserId(Integer.parseInt(orderuserid));
            o.setTimestamp((Timestamp) createddate);
            o.setStatus(orderstatus);
            order.add(o);
            line = br.readLine();
        }

        return order;
    }
    }


