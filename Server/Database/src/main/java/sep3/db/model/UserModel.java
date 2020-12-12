package sep3.db.model;

import java.util.List;

public interface UserModel {
    User ValidateUser(String userName, String password);

    List<Employee> getAllEmployees();

}
