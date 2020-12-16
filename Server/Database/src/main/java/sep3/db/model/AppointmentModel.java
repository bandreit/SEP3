package sep3.db.model;

import java.io.IOException;
import java.util.List;

public interface AppointmentModel {
    Appointment addAppointment(Appointment appointment);

    List<Appointment> getAppointments(String serviceId);
    List<Appointment> getUserAppointments(String userId);
}
