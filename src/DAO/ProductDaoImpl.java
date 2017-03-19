package DAO;

import Domain.Product;

import Exceptions.DataNotFound;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by esha on 2/20/17.
 */
public class ProductDaoImpl implements ProductInterface {

    public void save(Product product) throws SQLException, ClassNotFoundException {


        String code = product.getProductCode();
        String name = product.getProductName();
        int quantity = product.getQuantity();
        int unitprice = product.getUnitPrice();
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("Insert into  PRODUCT values (null,?,?,?,?)");
            pst.setString(1, code);
            pst.setString(2, name);
            pst.setInt(3, quantity);
            pst.setInt(4, unitprice);
            pst.executeUpdate();
            System.out.println("Product Data has been saved to database with primary Key :");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public Product getProductForProductId(int productId){
        Product product=null;
        Connection conn= null;
        ResultSet rs=null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = "+productId;
            PreparedStatement pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
        while(rs.next())
        {
            product=new Product(rs.getInt("PRODUCT_ID"),rs.getString("PRODUCT_CODE"),rs.getString("PRODUCT_NAME"),rs.getInt("PRODUCT_QUANTITY"),rs.getInt("PRODUCT_UNITPRICE"));
        }
        rs.close();
        } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
    e.printStackTrace();
}
return product;

}



public List<Product> getAllproduct(){
List<Product> users=new ArrayList<Product>();
Connection conn= null;
try {
        conn = DBConnection.getConnection();
        Statement stmt=conn.createStatement();
        String sql = "SELECT * FROM PRODUCT";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        //Retrieve by column name
        int id=rs.getInt("PRODUCT_ID");
        String code= rs.getString("PRODUCT_CODE");
        String name = rs.getString("PRODUCT_NAME");
        int quantity = rs.getInt("PRODUCT_QUANTITY");
        int unitprice = rs.getInt("PRODUCT_UNITPRICE");
        Product product=new Product(id,code,name,quantity,unitprice);

        users.add(product);
    }
    rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
    e.printStackTrace();
}
return users;
}
    public Product getById(int id) throws Exception {
        String query = "select PRODUCT_ID,PRODUCT_CODE,PRODUCT_QUANTITY,PRODUCT_UNITPRICE from PRODUCT where PRODUCT_ID=?";

        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        Product product = new Product();
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            product.setProductId(resultSet.getInt(1));
            product.setProductCode(resultSet.getString(2));
            product.setQuantity(resultSet.getInt(3));
            product.setUnitPrice(resultSet.getInt(4));
        }
        return product;
    }

public Product getproduct(int productId){
    Product product=null;
    Connection conn= null;
    ResultSet rs=null;
    try {
    conn = DBConnection.getConnection();
    String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = "+productId;
    PreparedStatement pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(sql);

    while(rs.next()){
//Retrieve by column name
        product=new Product(rs.getInt("PRODUCT_ID"),rs.getString("PRODUCT_CODE"),rs.getString("PRODUCT_NAME"),rs.getInt("PRODUCT_QUANTITY"),rs.getInt("PRODUCT_UNITPRICE"));
    }
        rs.close();
    }
    catch (SQLException e) {
        e.printStackTrace();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return product;
}

    public Product updateProductInfo(int productId, Product product)throws Exception{

        product=getProductForProductId(productId);
        if(product == null){
        throw new DataNotFound("Product with Product_Id"+productId+" does not exist");
        }
        else{
        Connection conn=DBConnection.getConnection();
        String sql="UPDATE PRODUCT set PRODUCT_CODE = ?, PRODUCT_NAME = ?, PRODUCT_QUANTITY= ?, PRODUCT_UNITPRICE= ? where PRODUCT_ID= ?";
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1,product.getProductCode());
        pst.setString(2,product.getProductName());
        pst.setInt(3,product.getQuantity());
        pst.setInt(4,product.getUnitPrice());
        pst.setInt(5,productId);
        pst.execute();
        System.out.println("Product details has been updated");
}
return null;
}



}














