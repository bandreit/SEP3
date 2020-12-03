package sep3.rest.appmngt.model;


import org.bson.types.ObjectId;

import java.util.Objects;

public class BusinessOwner extends User {
    private ObjectId _id;
    private String id;
    private String userName;
    private String password;
    private String domain;
    private String city;
    private String role;

    public BusinessOwner(String userName, String password) {
        super(userName, password);
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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
