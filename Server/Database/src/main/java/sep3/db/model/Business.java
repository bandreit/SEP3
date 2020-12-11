package sep3.db.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private ObjectId _id;
    private String id;
    private String name;
    private String location;
    private String mail;
    private List<Service> services;
    private List<Employee> employees;
    private String businessOwnerID;
    private ObjectId _businessOwnerId;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getBusinessOwnerID() {
        return businessOwnerID;
    }

    public void setBusinessOwnerID(String businessOwnerID) {
        this.businessOwnerID = businessOwnerID;
    }

    public ObjectId get_businessOwnerId() {
        return _businessOwnerId;
    }

    public void set_businessOwnerId(ObjectId _businessOwnerId) {
        this._businessOwnerId = _businessOwnerId;
    }
}

