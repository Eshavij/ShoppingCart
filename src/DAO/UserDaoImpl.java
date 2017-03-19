package DAO;

import Domain.User;
import Exceptions.DataNotFound;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by esha on 2/20/17.
 */
public class UserDaoImpl implements UserInterface {

    public void save(User user) throws Exception {
        String address = user.getAddress();
        String email = user.getEmail();
        String name = user.getName();
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("Insert into USER values (null,?,?,?)");
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, email);
        pst.execute();
        System.out.println("User Data has been saved to database with primary Key :");
        conn.close();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM USER";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("USER_ID");
                String name = rs.getString("USER_NAME");
                String address = rs.getString("USER_ADDRESS");
                String email = rs.getString("USER_EMAIL");
                User user = new User(id, name, address, email);
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }


    public User getUser() {
        return null;
    }



    public User getUserForId(int userId) {
        User user = null;
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM USER WHERE USER_ID= " + userId;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                user = new User(rs.getInt("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_ADDRESS"), rs.getString("USER_EMAIL"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }



    public void removeUser(int userId) throws Exception {


        User user = getUserForId(userId);


        Connection conn = DBConnection.getConnection();


        if (user == null) {


            throw new DataNotFound("No User exists with userId: " + userId);


        } else {


            String sql = "Delete from USER where USER_ID= " + userId;


            PreparedStatement pst = conn.prepareStatement(sql);


            pst.executeUpdate(sql);


            System.out.println("User with USER_ID :" + userId + " has been removed successfully");


        }



}



}












