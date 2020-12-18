package sep3.db.model;

import org.bson.types.ObjectId;

/**
 * The type Appointment.
 */
public class Appointment {
    private ObjectId _id;
    private String id;
    private String serviceId;
    private String scheduledTime;
    private String createdBy;
    private String serviceName;
    private Location selectedLocation;
    private String selectedEmployeeId;

    /**
     * Instantiates a new Appointment.
     *
     * @param _id                the id
     * @param id                 the id
     * @param serviceId          the service id
     * @param scheduledTime      the scheduled time
     * @param createdBy          the created by
     * @param selectedLocation   the selected location
     * @param selectedEmployeeId the selected employee id
     */
    public Appointment(ObjectId _id, String id, String serviceId, String scheduledTime, String createdBy, Location selectedLocation, String selectedEmployeeId) {
        this._id = _id;
        this.id = id;
        this.serviceId = serviceId;
        this.scheduledTime = scheduledTime;
        this.createdBy = createdBy;
        this.selectedLocation = selectedLocation;
        this.selectedEmployeeId = selectedEmployeeId;
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
     * Gets service id.
     *
     * @return the service id
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * Sets service id.
     *
     * @param serviceId the service id
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Gets scheduled time.
     *
     * @return the scheduled time
     */
    public String getScheduledTime() {
        return scheduledTime;
    }

    /**
     * Sets scheduled time.
     *
     * @param scheduledTime the scheduled time
     */
    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    /**
     * Gets created by.
     *
     * @return the created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets created by.
     *
     * @param createdBy the created by
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets service name.
     *
     * @return the service name
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets service name.
     *
     * @param serviceName the service name
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Gets selected location.
     *
     * @return the selected location
     */
    public Location getSelectedLocation() {
        return selectedLocation;
    }

    /**
     * Sets selected location.
     *
     * @param selectedLocation the selected location
     */
    public void setSelectedLocation(Location selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    /**
     * Gets selected employee id.
     *
     * @return the selected employee id
     */
    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    /**
     * Sets selected employee id.
     *
     * @param selectedEmployeeId the selected employee id
     */
    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }
}
