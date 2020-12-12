package sep3.rest.appmngt.model;

import org.bson.types.ObjectId;

import java.util.Objects;

public class User {
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

    public User() {
    }

    public User(String userName, String password) {
        this.id = null;
        this.userName = userName;
        this.password = password;
        this.email = null;
        this.city = null;
        this.role = null;
        this.firstName=null;
        this.lastName=null;
        this.phone=null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
