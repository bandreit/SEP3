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

    public Business(ObjectId _id,String id,String name, String location, String mail) {
        this._id = _id;
        this.id=id;
        this.name = name;
        this.location = location;
        this.mail = mail;
        this.services = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public ObjectId get_id() {
        return _id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getMail() {
        return mail;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setServices(List<Service> services) { this.services = services; }
}
