package sep3.rest.appmngt.model;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface UserModel {
    User ValidateUser(String userName, String password) throws IOException;

    User RegisterUser(User user) throws IOException;

    List<Employee> getAllEmployees() throws IOException;
}
