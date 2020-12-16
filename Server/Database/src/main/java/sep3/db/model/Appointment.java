package sep3.db.model;

import org.bson.types.ObjectId;

public class Appointment {
    private ObjectId _id;
    private String id;
    private String serviceId;
    private String scheduledTime;
    private String createdBy;
    private Location selectedLocation;
    private String selectedEmployeeId;

    public Appointment(ObjectId _id, String id, String serviceId, String scheduledTime, String createdBy, Location selectedLocation, String selectedEmployeeId) {
        this._id = _id;
        this.id = id;
        this.serviceId = serviceId;
        this.scheduledTime = scheduledTime;
        this.createdBy = createdBy;
        this.selectedLocation = selectedLocation;
        this.selectedEmployeeId = selectedEmployeeId;
    }

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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Location getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(Location selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }
}
