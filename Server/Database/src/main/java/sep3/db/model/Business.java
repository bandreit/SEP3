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
    private String _businessOwnerID;
    private ObjectId businessOwnerID;

    public Business() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public String get_businessOwnerID() {
        return _businessOwnerID;
    }

    public void set_businessOwnerID(String _businessOwnerID) {
        this._businessOwnerID = _businessOwnerID;
    }

    public ObjectId getBusinessOwnerID() {
        return businessOwnerID;
    }

    public void setBusinessOwnerID(ObjectId businessOwnerID) {
        this.businessOwnerID = businessOwnerID;
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

}