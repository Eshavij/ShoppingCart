package DAO;

import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;


/**
 * Created by esha on 2/20/17.
 */
public class OrderDetailsDaoImpl implements OrderDetailsInterface {
    public void save(OrderDetails orderDetails) throws Exception {

        Product prId = orderDetails.getOrderDetailsProductId();
        int odQty = orderDetails.getOrderDetailsQty();
        int odUnitPrice = orderDetails.getOrderDetailsUnitPrice();
        int odTotalPrice = orderDetails.getOrderDetailsTotalPrice();
        Order orderId = orderDetails.getOrderDetailsOrderId();
        System.out.println(orderId.getOrderId());
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("Insert into ORDER_DETAILS values (null,?,?,?,?,?)");
        pst.setInt(1, prId.getProductId());
        pst.setInt(2, odQty);
        pst.setInt(3, odUnitPrice);
        pst.setInt(4, odTotalPrice);
        pst.setInt(5, orderId.getOrderId());
        pst.execute();
        System.out.println("User Data has been saved to database with primary Key as OD_ID :");

        conn.close();
    }

    public OrderDetails getOrderDetailsForId(int odId) throws Exception {
        OrderDaoImpl odDao = new OrderDaoImpl();

        ProductDaoImpl pdDao = new ProductDaoImpl();
        OrderDetails orderDetails = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from ORDER_DETAILS where OD_ID= " + odId;
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, odId);
            rs = pst.executeQuery(sql);
            while (rs.next()) {
//Retrieve by column name
                Product p = pdDao.getProductForProductId(rs.getInt("OD_PRODUCT_ID"));
                Order o = odDao.getOrderForOrderId(rs.getInt("OD_ORDER_ID"));
                orderDetails = new OrderDetails(rs.getInt("OD_ID"), p, rs.getInt("OD_QTY"), rs.getInt("OD_UNITPRICE"), rs.getInt("OD_TOTALPRICE"), o);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderDetails;

    }

    @Override
    public List<OrderDetails> getAllOrderDetails() throws Exception {
        return null;
    }
}
