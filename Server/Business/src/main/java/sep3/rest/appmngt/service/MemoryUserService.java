package sep3.rest.appmngt.service;

import org.springframework.beans.factory.annotation.Autowired;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.model.User;
import sep3.rest.appmngt.model.UserDAO;
import sep3.rest.appmngt.model.UserDAOImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MemoryUserService implements UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    public MemoryUserService() throws IOException {
    }

    @Override
    public User ValidateUser(String userName, String password) throws IOException {
        return userDAO.ValidateUser(userName, password);
    }
}
