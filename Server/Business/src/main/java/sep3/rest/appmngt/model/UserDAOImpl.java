package sep3.rest.appmngt.model;

import sep3.rest.appmngt.service.UserService;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    private ArrayList<User> userList;

    public UserDAOImpl() {
        userList = new ArrayList<>();
        User user = new User("hello", "gooodbyee");
        User user1 = new User("BYEE", "hi");
        userList.add(user);
        userList.add(user1);
    }

    @Override
    public User ValidateUser(String userName, String password) {
        {
            return userList.stream().filter(u -> u.getName().equals(userName)).findFirst().orElse(null);
        }
    }
}
