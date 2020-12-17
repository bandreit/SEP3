import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import sep3.rest.appmngt.model.Appointment;
import sep3.rest.appmngt.model.Location;
import sep3.rest.appmngt.service.AppointServiceImpl;
import sep3.rest.appmngt.service.AppointmentService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class AppointmentServiceTest {
    private final AppointmentService appointmentService = new AppointServiceImpl();

    public AppointmentServiceTest() throws IOException {
    }

    @Test
    void addAppointment() throws IOException {
        Appointment appointment = new Appointment(new ObjectId(), "", "5fd93377240da15fc83aaa7b", "12.16.2020 9:30 a.m.", "123", new Location("afg", "Egfa"), "5fd8f9ef985b570914dc04b8");
        Appointment appointment1 = appointmentService.addAppointment(appointment);
        assertThat(appointment, notNullValue());
    }
}
