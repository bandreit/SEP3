package sep3.rest.appmngt.network;


import sep3.rest.appmngt.model.Appointment;

/**
 * The type Book appointment package.
 */
public class BookAppointmentPackage extends NetworkPackage {
    private Appointment appointment;

    /**
     * Instantiates a new Book appointment package.
     *
     * @param type        the type
     * @param appointment the appointment
     */
    public BookAppointmentPackage(NetworkType type, Appointment appointment) {
        super(type);
        this.appointment = appointment;
    }

    /**
     * Gets appointment.
     *
     * @return the appointment
     */
    public Appointment getAppointment() {
        return appointment;
    }
}
