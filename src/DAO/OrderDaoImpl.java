package DAO;

import Domain.Order;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by esha on 2/20/17.
 */
public class OrderDaoImpl implements OrderDaoInterface{

    public int save(Order order) throws SQLException, ClassNotFoundException {

        Timestamp time= new Timestamp(new Date().getTime());
        Date date = new Date();
        int userId=order.getuserid();
        String status=order.getStatus();
        int orderId=0;
        Connection conn= DBConnection.getConnection();

        PreparedStatement ps=conn.prepareStatement("insert into ORDERS(ORDER_USERID,ORDER_CREATED_DATE,ORDER_STATUS) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,userId);
        ps.setString(2, date.toString());
        ps.setString(3,status);
        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();
        if(resultSet.next()){
            orderId = resultSet.getInt(1);
        }
        System.out.println("Order Data has been saved to database with primary Key as ORDER_ID :");

        return orderId;

    }
    public Order getOrderForOrderId(int orderId) throws Exception {
        Order order=null;
        UserDaoImpl udao=new UserDaoImpl();
        Connection conn= null;
        ResultSet rs=null;
        try
        {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = "+orderId;
            PreparedStatement pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);

            while(rs.next()) {
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return order;
    }
    public List<Order> getAllOrders(){
        UserDaoImpl udao=new UserDaoImpl();
        List<Order> orders=new ArrayList<Order>();
        Connection conn= null;
        ResultSet rs=null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM ORDERS";
            PreparedStatement pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);

            while(rs.next()){

            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }


}


