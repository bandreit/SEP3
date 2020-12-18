package sep3.rest.appmngt.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Business.
 */
public class Business {
    private String id;
    private String name;
    private List<Location> locations;
    private String mail;
    private List<String> services;
    private List<String> employees;
    private String businessOwnerID;

    /**
     * Instantiates a new Business.
     *
     * @param id              the id
     * @param name            the name
     * @param mail            the mail
     * @param businessOwnerID the business owner id
     */
    public Business(String id, String name, String mail, String businessOwnerID) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.businessOwnerID = businessOwnerID;
        this.locations = new ArrayList<>();
        this.services = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    /**
     * Sets locations.
     *
     * @param locations the locations
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Gets business owner id.
     *
     * @return the business owner id
     */
    public String getBusinessOwnerID() {
        return businessOwnerID;
    }

    /**
     * Sets business owner id.
     *
     * @param businessOwnerID the business owner id
     */
    public void setBusinessOwnerID(String businessOwnerID) {
        this.businessOwnerID = businessOwnerID;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets mail.
     *
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets mail.
     *
     * @param mail the mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Gets services.
     *
     * @return the services
     */
    public List<String> getServices() {
        return services;
    }

    /**
     * Sets services.
     *
     * @param services the services
     */
    public void setServices(List<String> services) {
        this.services = services;
    }

    /**
     * Gets employees.
     *
     * @return the employees
     */
    public List<String> getEmployees() {
        return employees;
    }

    /**
     * Sets employees.
     *
     * @param employees the employees
     */
    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }
}