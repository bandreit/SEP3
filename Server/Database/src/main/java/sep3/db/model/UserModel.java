package sep3.db.model;

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
     */
    User ValidateUser(String userName);

    /**
     * Register user user.
     *
     * @param user the user
     * @return the user
     */
    User RegisterUser(User user);

    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    List<Employee> getAllEmployees();

}
