package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface UserService {
    User ValidateUser(String userName, String password) throws IOException;

    void addUser(User user) throws IOException;
}
