package Service;

import DAO.UserDaoImpl;

import Domain.User;

import java.util.List;

/**
 * Created by esha on 2/21/17.
 */
public  class UserService  implements UserServiceInterface {




    public void insertuser(User user) {

        UserDaoImpl userDao = new UserDaoImpl();
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public List<User> allUsers() {
        UserDaoImpl userDao = new UserDaoImpl();

            return userDao.getAllUsers();

    }




    public void getUser(int userId) {
        UserDaoImpl userDao = new UserDaoImpl();
         userDao.getUser();


    }

    @Override
    public void removeUser(int userid) {

    }


    public void deleteUser(int i) throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.removeUser(3);
    }



}



