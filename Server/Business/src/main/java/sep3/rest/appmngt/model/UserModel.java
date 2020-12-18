package sep3.rest.appmngt.model;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

/**
 * The interface User model.
 */
public interface UserModel {
    /**
     * Validate user user.
     *
     * @param userName the user name
     * @return the user
     * @throws IOException the io exception
     */
    User ValidateUser(String userName) throws IOException;

    /**
     * Register user user.
     *
     * @param user the user
     * @return the user
     * @throws IOException the io exception
     */
    User RegisterUser(User user) throws IOException;

    /**
     * Gets all employees.
     *
     * @return the all employees
     * @throws IOException the io exception
     */
    List<Employee> getAllEmployees() throws IOException;
}
