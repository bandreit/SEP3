package sep3.db.network;

import sep3.db.model.Appointment;

public class BookAppointmentPackage extends NetworkPackage {
    private Appointment appointment;

    public BookAppointmentPackage(NetworkType type, Appointment appointment) {
        super(type);
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }
}
