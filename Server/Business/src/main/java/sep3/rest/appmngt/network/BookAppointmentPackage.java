package sep3.rest.appmngt.network;


import sep3.rest.appmngt.model.Appointment;

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
