package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Validate user user.
     *
     * @param userName the user name
     * @return the user
     * @throws IOException the io exception
     */
    User ValidateUser(String userName) throws IOException;

    /**
     * Add user user.
     *
     * @param user the user
     * @return the user
     * @throws IOException the io exception
     */
    User addUser(User user) throws IOException;

    /**
     * Gets all employees.
     *
     * @return the all employees
     * @throws IOException the io exception
     */
    List<Employee> getAllEmployees() throws IOException;
}
