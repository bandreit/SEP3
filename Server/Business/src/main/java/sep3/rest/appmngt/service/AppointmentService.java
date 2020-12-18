package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Appointment;

import java.io.IOException;
import java.util.List;

/**
 * The interface Appointment service.
 */
public interface AppointmentService  {
    /**
     * Add appointment appointment.
     *
     * @param appointment the appointment
     * @return the appointment
     * @throws IOException the io exception
     */
    Appointment addAppointment(Appointment appointment) throws IOException;

    /**
     * Gets appointments.
     *
     * @param serviceId the service id
     * @return the appointments
     * @throws IOException the io exception
     */
    List<Appointment> getAppointments(String serviceId) throws IOException;

    /**
     * Gets user appointments.
     *
     * @param userId the user id
     * @return the user appointments
     * @throws IOException the io exception
     */
    List<Appointment> getUserAppointments(String userId) throws IOException;

    /**
     * Delete appointment string.
     *
     * @param appointmentId the appointment id
     * @return the string
     * @throws IOException the io exception
     */
    String deleteAppointment(String appointmentId) throws IOException;
}
