package sep3.rest.appmngt.model;

import org.springframework.http.ResponseEntity;

public interface UserDAO {
    User ValidateUser(String userName, String password);
}
