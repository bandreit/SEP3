package sep3.rest.appmngt.model;

import java.util.Objects;

public class User {
    private String id;
    private String userName;
    private String password;
    private String domain;
    private String city;
    private String role;
    private int securityLevel;

    public User(String id, String userName, String password, String domain, String city, String role, int securityLevel) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.domain = domain;
        this.city = city;
        this.role = role;
        this.securityLevel = securityLevel;
    }

    public User(String userName, String password) {
        this.id = null;
        this.userName = userName;
        this.password = password;
        this.domain = null;
        this.city = null;
        this.role = null;
        this.securityLevel = 0;
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

    public int getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
