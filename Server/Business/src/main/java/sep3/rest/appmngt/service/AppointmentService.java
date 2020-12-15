package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Appointment;

import java.io.IOException;
import java.util.List;

public interface AppointmentService  {
    Appointment addAppointment(Appointment appointment) throws IOException;

    List<Appointment> getAppointments(String serviceId) throws IOException;
}
