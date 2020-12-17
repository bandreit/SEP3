package sep3.rest.appmngt.model;

import java.io.IOException;
import java.util.List;

public interface AppointmentModel {
    Appointment addAppointment(Appointment appointment) throws IOException;

    List<Appointment> getAppointments(String serviceId) throws IOException;
    List<Appointment> getUserAppointments(String userId) throws IOException;
    String deleteAppointment(String appointmentId) throws IOException;
}
