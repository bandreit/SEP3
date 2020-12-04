package sep3.db.model;

public interface Model {
    User ValidateUser(String userName, String password);
    BusinessOwner getBusinessOwner(String id);
}
