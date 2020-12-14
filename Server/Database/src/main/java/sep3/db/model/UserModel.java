package sep3.db.model;

import java.util.List;

public interface UserModel {
    User ValidateUser(String userName, String password);
    User RegisterUser(User user);
    List<Employee> getAllEmployees();

}
