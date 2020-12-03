package sep3.rest.appmngt.model;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface UserModel {
    User ValidateUser(String userName, String password) throws IOException;
}
