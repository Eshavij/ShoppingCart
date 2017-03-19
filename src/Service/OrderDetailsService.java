package Service;


import DAO.*;
import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;
import Exceptions.OutOfStock;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by esha on 2/21/17.
 */
public class OrderDetailsService {

    OrderDetailsDaoImpl orderDetailsDao=new OrderDetailsDaoImpl();
    ProductDaoImpl productDao =new ProductDaoImpl();
    OrderDaoImpl orderDao=new OrderDaoImpl();


    public OrderDetailsService(){
        this.orderDetailsDao=new OrderDetailsDaoImpl();
        this.productDao=new ProductDaoImpl();
        this.orderDao=new OrderDaoImpl();
    }

    public void generateOrderDetailsCSV(){
        try{
            List<OrderDetails> orderDetailsList= orderDetailsDao.getAllOrderDetails();
            BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/esha/Downloads/OrderDetailsCSV.csv"));
            String caVal="Serial No, \t Product Name,\t Quantity Ordered, \t Unit Price, \t Total Price, \t Order No. Reference \n";
            bw.write(caVal);

            for (OrderDetails orderDetails:orderDetailsList){

                int oDetailsId=orderDetails.getOrderDetailsId();
                Product product=orderDetails.getOrderDetailsProductId();
                int orderQty=orderDetails.getOrderDetailsQty();
                int unitPrice=product.getUnitPrice();
                int totalPrice=unitPrice*orderQty;
                Order orderId=orderDetails.getOrderDetailsOrderId();



                caVal=oDetailsId+", \t"+product.getProductName()+", \t"+orderQty+", \t"+unitPrice+", \t"+totalPrice+", \t"+orderId+"\n";
                bw.write(caVal);
            }
            bw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("OrderDetailsCSV.csv has been generated in Downloads directory");
    }

    public void makeOrderDetail(int productId, int orderId,int qtyPurchased)throws Exception {
            System.out.println(productId);
        Product product=productDao.getProductForProductId(productId);
        System.out.println(product.toString()+ product.getProductId());
        Order order=orderDao.getOrderForOrderId(orderId);

        System.out.println(order.toString());
        if(product.getQuantity()-qtyPurchased>=0) {
            product.setQuantity(product.getQuantity() - qtyPurchased);
            try {
                productDao.updateProductInfo(productId, product);
                System.out.println("i am here");
                OrderDetails orderDetails = new OrderDetails(product, qtyPurchased, product.getUnitPrice(), qtyPurchased * product.getUnitPrice(), order);

                orderDetailsDao.save(orderDetails);
            } catch (Exception e) {
                throw e;
            }
        }
        else{
            throw new OutOfStock("The Order can't be placed, since this product is out of stock at the moment");
        }

}
public List<OrderDetails> getAllOrderDetails()throws Exception{
return orderDetailsDao.getAllOrderDetails();
}
public OrderDetails getOrderDetail(int orderDetailId)throws Exception{
return orderDetailsDao.getOrderDetailsForId(orderDetailId);
}
}



