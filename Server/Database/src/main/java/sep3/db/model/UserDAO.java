package sep3.db.model;

public interface UserDAO {
  User ValidateUser(String userName, String password);
}
