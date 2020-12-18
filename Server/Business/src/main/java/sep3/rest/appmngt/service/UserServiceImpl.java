package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserModel userModel = new UserModelImpl();

    /**
     * Instantiates a new User service.
     *
     * @throws IOException the io exception
     */
    public UserServiceImpl() throws IOException {
    }

    /**
     * Usermodel calls validate User by username
     *
     * @param userName String
     * @return a user with username
     */
    @Override
    public User ValidateUser(String userName) throws IOException {
        return userModel.ValidateUser(userName);
    }
    /**
     * Usermodel creates new object of User and calls registeruser
     *
     * @param user User
     * @return registered user
     */
    @Override
    public User addUser(User user) throws IOException {
        User userToRegister = new User(user.getId(), user.getUserName(), user.getPassword(), user.getEmail(),
                user.getCity(), user.getRole(), user.getFirstName(), user.getLastName(), user.getPhone());
        return userModel.RegisterUser(userToRegister);
    }
    /**
     * Usermodel calls getAllEmployees
     * @return all employees
     */
    @Override
    public List<Employee> getAllEmployees() throws IOException {
        return userModel.getAllEmployees();
    }
}
