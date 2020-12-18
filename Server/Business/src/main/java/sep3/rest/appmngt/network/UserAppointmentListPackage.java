package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Appointment;

import java.util.List;

/**
 * The type User appointment list package.
 */
public class UserAppointmentListPackage extends NetworkPackage {
    private List<Appointment> appointments;
    private String userId;

    /**
     * Instantiates a new User appointment list package.
     *
     * @param type         the type
     * @param userId       the user id
     * @param appointments the appointments
     */
    public UserAppointmentListPackage(NetworkType type, String userId, List<Appointment> appointments) {
        super(type);
        this.appointments = appointments;
        this.userId = userId;
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
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }
}