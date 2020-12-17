package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Appointment;

import java.util.List;

public class UserAppointmentListPackage extends NetworkPackage {
    private List<Appointment> appointments;
    private String userId;

    public UserAppointmentListPackage(NetworkType type, String userId, List<Appointment> appointments) {
        super(type);
        this.appointments = appointments;
        this.userId = userId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public String getUserId() {
        return userId;
    }
}