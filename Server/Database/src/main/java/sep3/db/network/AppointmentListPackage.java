package sep3.db.network;

import sep3.db.model.Appointment;

import java.util.List;

/**
 * The type Appointment list package.
 */
public class AppointmentListPackage extends NetworkPackage {
    private List<Appointment> appointments;
    private String serviceId;

    /**
     * Instantiates a new Appointment list package.
     *
     * @param type         the type
     * @param serviceId    the service id
     * @param appointments the appointments
     */
    public AppointmentListPackage(NetworkType type, String serviceId, List<Appointment> appointments) {
        super(type);
        this.appointments = appointments;
        this.serviceId = serviceId;
    }

    /**
     * Gets appointments.
     *
     * @return the appointments
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Gets service id.
     *
     * @return the service id
     */
    public String getServiceId() {
        return serviceId;
    }
}
