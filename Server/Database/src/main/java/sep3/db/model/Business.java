package sep3.db.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private String id;
    private ObjectId _id;
    private String name;
    private List<String> locations;
    private String mail;
    private List<String> services;
    private List<String> employees;
    private String businessOwnerID;

    public Business() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocation(List<String> location) {
        this.locations = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }

    public String getBusinessOwnerID() {
        return businessOwnerID;
    }

    public void setBusinessOwnerID(String businessOwnerID) {
        this.businessOwnerID = businessOwnerID;
    }
}