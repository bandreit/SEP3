package sep3.rest.appmngt.model;

import org.bson.types.ObjectId;

public class Appointment {
    private ObjectId _id;
    private String id;
    private String serviceId;
    private String scheduledTime;
    private String name;
    private String email;
    private String phone;
    private String selectedLocation;
    private String selectedEmployeeId;

    public Appointment(ObjectId _id, String id, String serviceId, String scheduledTime, String name, String email, String phone, String selectedLocation, String selectedEmployeeId) {
        this._id = _id;
        this.id = id;
        this.serviceId = serviceId;
        this.scheduledTime = scheduledTime;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }
}
