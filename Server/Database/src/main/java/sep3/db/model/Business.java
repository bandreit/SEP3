package sep3.db.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Business {
    @Expose(serialize = true, deserialize = true)
    private String id;
    @Expose(serialize = true, deserialize = true)
    private ObjectId _id;
    @Expose(serialize = true, deserialize = true)
    private String name;
    @Expose(serialize = true, deserialize = false)
    private List<Location> locations;
    @Expose(serialize = true, deserialize = true)
    private String mail;
    @Expose(serialize = true, deserialize = false)
    private List<String> services;
    @Expose(serialize = true, deserialize = false)
    private List<String> employees;
    @Expose(serialize = true, deserialize = false) // null pointer if false
    private String businessOwnerID;
    @Expose(serialize = true, deserialize = false) // expected string
    private ObjectId _businessOwnerID;

    public Business(String id, ObjectId _id, String name, String mail, String businessOwnerID, ObjectId _businessOwnerID) {
        this.id = id;
        this._id = _id;
        this.name = name;
        this.mail = mail;
        this.businessOwnerID = businessOwnerID;
        this._businessOwnerID = _businessOwnerID;
        this.services = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public String getBusinessOwnerID() {
        return businessOwnerID;
    }

    public void setBusinessOwnerID(String businessOwnerID) {
        this.businessOwnerID = businessOwnerID;
    }

    public ObjectId get_businessOwnerID() {
        return _businessOwnerID;
    }

    public void set_businessOwnerID(ObjectId _businessOwnerID) {
        this._businessOwnerID = _businessOwnerID;
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