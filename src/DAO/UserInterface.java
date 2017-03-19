package DAO;

import Domain.User;
import java.util.List;

/**
 * Created by esha on 2/21/17.
 */
public interface UserInterface {
      public void save(User user)throws Exception;

        public List<User> getAllUsers();

        public User getUserForId(int userId);

        public void removeUser(int userId)throws Exception;
}

