package sep3.db.model;

import org.bson.types.ObjectId;

import java.util.Objects;

public class User {
    private ObjectId _id;
    private String id;
    private String userName;
    private String password;
    private String email;
    private String city;
    private String role;
    private String firstName;
    private String lastName;
    private String phone;

    public User(String id, String userName, String password, String email, String city, String role, String firstName, String lastName, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.city = city;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public int hashCode() {
        return Objects.hash(userName, password);
    }

}
