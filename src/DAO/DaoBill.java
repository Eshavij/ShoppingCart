package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by esha on 3/6/17.
 */
public class DaoBill {
    public ArrayList<Integer> Billdetail(int orderid) throws Exception{

        ArrayList<Integer> arrayList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String query = "select * from ORDER_DETAILS where OD_ORDER_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,orderid);
        preparedStatement.executeQuery();

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("OD_PRODUCT_ID");
            int quantity = resultSet.getInt("OD_QTY");

            arrayList.add(quantity);
            arrayList.add(id);
        }
        preparedStatement.close();
        connection.close();
        return arrayList;
    }


}
