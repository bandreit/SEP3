package sep3.rest.appmngt.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Business {
    private String id;
    private String name;
    private List<Location> locations;
    private String mail;
    private List<String> services;
    private List<String> employees;
    private String businessOwnerID;

    public Business(String id, String name, String mail, String businessOwnerID) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.businessOwnerID = businessOwnerID;
        this.locations = new ArrayList<>();
        this.services = new ArrayList<>();
        this.employees = new ArrayList<>();
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