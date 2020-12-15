package sep3.rest.appmngt.model;

import java.io.IOException;
import java.util.List;

public interface AppointmentModel {
    Appointment addAppointment(Appointment appointment) throws IOException;

    List<Appointment> getAppointments(String serviceId) throws IOException;
}
