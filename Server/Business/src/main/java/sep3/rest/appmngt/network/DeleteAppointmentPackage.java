package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Appointment;

import java.util.List;

public class DeleteAppointmentPackage extends NetworkPackage {
    private String appointmentId;

    public DeleteAppointmentPackage(NetworkType type, String appointmentId) {
        super(type);
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }
}
