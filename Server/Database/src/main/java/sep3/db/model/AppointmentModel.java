package sep3.db.model;

import java.util.List;

/**
 * The interface Appointment model.
 */
public interface AppointmentModel {
    /**
     * Add appointment appointment.
     *
     * @param appointment the appointment
     * @return the appointment
     */
    Appointment addAppointment(Appointment appointment);

    /**
     * Gets appointments.
     *
     * @param serviceId the service id
     * @return the appointments
     */
    List<Appointment> getAppointments(String serviceId);

    /**
     * Gets user appointments.
     *
     * @param userId the user id
     * @return the user appointments
     */
    List<Appointment> getUserAppointments(String userId);

    /**
     * Delete appointment string.
     *
     * @param appointmentId the appointment id
     * @return the string
     */
    String deleteAppointment(String appointmentId);
}
