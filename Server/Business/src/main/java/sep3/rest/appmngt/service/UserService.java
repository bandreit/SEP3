package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User ValidateUser(String userName, String password) throws IOException;

    void addUser(User user) throws IOException;

    List<Employee> getAllEmployees() throws IOException;
}
