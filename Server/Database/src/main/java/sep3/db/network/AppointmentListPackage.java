package sep3.db.network;

import sep3.db.model.Appointment;

import java.util.List;

public class AppointmentListPackage extends NetworkPackage {
    private List<Appointment> appointments;
    private String serviceId;

    public AppointmentListPackage(NetworkType type, String serviceId, List<Appointment> appointments) {
        super(type);
        this.appointments = appointments;
        this.serviceId = serviceId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public String getServiceId() {
        return serviceId;
    }
}
