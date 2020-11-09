package main.java.sep3.rest.appmngt.service;

import main.java.sep3.rest.appmngt.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User ValidateUser(String userName, String password);
}
