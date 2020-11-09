package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User ValidateUser(String userName, String password);
}
