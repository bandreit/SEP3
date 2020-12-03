package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.User;
import sep3.rest.appmngt.model.UserModel;
import sep3.rest.appmngt.model.UserModelImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MemoryUserService implements UserService {
    private final UserModel userDAO = new UserModelImpl();

    public MemoryUserService() throws IOException {
    }

    @Override
    public User ValidateUser(String userName, String password) throws IOException {
        return userDAO.ValidateUser(userName, password);
    }
}
