package sep3.db.model;

import java.util.List;

public interface AppointmentModel {
    Appointment addAppointment(Appointment appointment);

    List<Appointment> getAppointments(String serviceId);
    List<Appointment> getUserAppointments(String userId);
    String deleteAppointment(String appointmentId);
}
