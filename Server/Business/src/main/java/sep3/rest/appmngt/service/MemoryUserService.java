package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.User;
import sep3.rest.appmngt.model.UserDAO;
import sep3.rest.appmngt.model.UserDAOImpl;
import org.springframework.stereotype.Service;

@Service
public class MemoryUserService implements UserService {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public User ValidateUser(String userName, String password) {
        return userDAO.ValidateUser(userName, password);
    }
}
