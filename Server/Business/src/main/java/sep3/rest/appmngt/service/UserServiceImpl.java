package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserModel userModel = new UserModelImpl();

    public UserServiceImpl() throws IOException {
    }


    @Override
    public User ValidateUser(String userName) throws IOException {
        return userModel.ValidateUser(userName);
    }

    @Override
    public User addUser(User user) throws IOException {
        User userToRegister = new User(user.getId(), user.getUserName(), user.getPassword(), user.getEmail(),
                user.getCity(), user.getRole(), user.getFirstName(), user.getLastName(), user.getPhone());
        return userModel.RegisterUser(userToRegister);
    }

    @Override
    public List<Employee> getAllEmployees() throws IOException {
        return userModel.getAllEmployees();
    }
}
