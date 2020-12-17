package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

@Service
public class AppointServiceImpl implements AppointmentService {
    private final AppointmentModel appointmentModel = new AppointmentModelImpl();

    public AppointServiceImpl() throws IOException {
    }

    @Override
    public Appointment addAppointment(Appointment appointment) throws IOException {
        return appointmentModel.addAppointment(appointment);
    }

    @Override
    public List<Appointment> getAppointments(String serviceId) throws IOException {
        return appointmentModel.getAppointments(serviceId);
    }

    @Override
    public List<Appointment> getUserAppointments(String userId) throws IOException {
        return appointmentModel.getUserAppointments(userId);
    }

    @Override
    public String deleteAppointment(String appointmentId) throws IOException {
        return appointmentModel.deleteAppointment(appointmentId);
    }
}
