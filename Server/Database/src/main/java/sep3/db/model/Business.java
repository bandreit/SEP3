package sep3.db.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Business.
 */
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

    /**
     * Instantiates a new Business.
     *
     * @param id               the id
     * @param _id              the id
     * @param name             the name
     * @param mail             the mail
     * @param businessOwnerID  the business owner id
     * @param _businessOwnerID the business owner id
     */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Sets id.
     *
     * @param _id the id
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
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
     * Gets business owner id.
     *
     * @return the business owner id
     */
    public ObjectId get_businessOwnerID() {
        return _businessOwnerID;
    }

    /**
     * Sets business owner id.
     *
     * @param _businessOwnerID the business owner id
     */
    public void set_businessOwnerID(ObjectId _businessOwnerID) {
        this._businessOwnerID = _businessOwnerID;
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