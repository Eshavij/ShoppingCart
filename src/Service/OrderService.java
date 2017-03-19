package Service;


import DAO.OrderDaoImpl;
import DAO.OrderDaoInterface;

import DAO.UserDaoImpl;
import Domain.*;

import java.util.List;
import java.io.*;


/**
 * Created by esha on 2/21/17.
 */
public class OrderService {

        OrderDaoInterface orderDaoInterface;
    UserDaoImpl userDaoInterface;

        public OrderService() {
            this.orderDaoInterface=new OrderDaoImpl();
            this.userDaoInterface=new UserDaoImpl();
        }

        public void makeOrder() throws Exception {
            String cvorder = "resources/order.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(cvorder));

            String space="";
            String comma=",";

            String addrow = bufferedReader.readLine();
            int userId = Integer.parseInt(addrow);

            Order domainOrder = new Order();
            domainOrder.setUserId(userId);
            domainOrder.setStatus("Confirmed");

            int orderId = 0;

            OrderDaoImpl daoOrder = new OrderDaoImpl();
            try {
                orderId = daoOrder.save(domainOrder);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public Order getOrder(int orderId) throws Exception {

            BillService billService = new BillService();
            billService.billgenerate(orderId);
            return orderDaoInterface.getOrderForOrderId(orderId);
        }

        public List<Order> getAllOrders(){
            return orderDaoInterface.getAllOrders();
        }


    }





