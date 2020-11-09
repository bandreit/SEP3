package main.java.sep3.rest.appmngt.model;

import java.util.Objects;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
