package Client;

import DAO.UserDaoImpl;
import Domain.User;
import Service.UserService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * Created by esha on 2/20/17.
 */
public class UserClient {
    public static void main(String[] args) {

            try {
                List<User> users = CSVFileReader.readUserCSV();
                UserDaoImpl udao = new UserDaoImpl();
                UserService uservice = new UserService();

                for (User user : users) {
                    uservice.insertuser(user);

                    UserService us = new UserService();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


                UserService us = new UserService();
                List<User> ls = us.allUsers();
                for (User user : ls) {
                    System.out.println(user.toString());
                }


            //delete

                UserService del = new UserService();
                try {
                 //   del.deleteUser(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }



        }
    }








