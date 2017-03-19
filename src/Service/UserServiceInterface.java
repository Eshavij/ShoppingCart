package Service;


import Domain.User;
import java.util.List;

/**
 * Created by esha on 3/4/17.
 */
public interface UserServiceInterface {


    public void insertuser(User user) ;
    public List<User> allUsers();
    public void getUser(int userId);
    public void removeUser(int userid);

}

