package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

/**
 * The type Appoint service.
 */
@Service
public class AppointServiceImpl implements AppointmentService {
    private final AppointmentModel appointmentModel = new AppointmentModelImpl();

    /**
     * Instantiates a new Appoint service.
     *
     * @throws IOException the io exception
     */
    public AppointServiceImpl() throws IOException {
    }
    /**
     * Appointment model calls to add appointment
     * @param appointment Appointment
     * @return added appointment
     */
    @Override
    public Appointment addAppointment(Appointment appointment) throws IOException {
        return appointmentModel.addAppointment(appointment);
    }

    /**
     * Appointment model calls to get appointments by id
     * @param serviceId String
     * @return all appointments with the same service id
     */
    @Override
    public List<Appointment> getAppointments(String serviceId) throws IOException {
        return appointmentModel.getAppointments(serviceId);
    }

    /**
     * Appointment model calls to get user appointments
     * @param userId String
     * @return all users appointments
     */
    @Override
    public List<Appointment> getUserAppointments(String userId) throws IOException {
        return appointmentModel.getUserAppointments(userId);
    }
    /**
     * Appointment model calls to delete appointment by id
     * @param appointmentId String
     * @return deleted appointment
     */
    @Override
    public String deleteAppointment(String appointmentId) throws IOException {
        return appointmentModel.deleteAppointment(appointmentId);
    }
}
