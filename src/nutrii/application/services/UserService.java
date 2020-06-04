package nutrii.application.services;

import java.util.ArrayList;
import nutrii.application.model.User;

/**
 *
 * @author Ellaira
 */
public interface UserService {
   public User userLogin(String userName, String password);
   
    public ArrayList<User> getUsers();

    public User loadUser(int userid);

    public boolean delUser(int userid);

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public ArrayList<User> searchUserByName(String userName);

    public ArrayList<User> getUserByLifestyle(String lifestyle);
}
