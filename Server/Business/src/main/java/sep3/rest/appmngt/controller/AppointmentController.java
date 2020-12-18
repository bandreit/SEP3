package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep3.rest.appmngt.model.Appointment;
import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.service.AppointmentService;
import sep3.rest.appmngt.service.BusinessService;

import java.io.IOException;
import java.util.List;

/**
 * The type Appointment controller.
 */
@RestController
@RequestMapping("/SEP3")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    /**
     * Add appointment response entity.
     *
     * @param appointment the appointment
     * @return the response entity
     */
    @PostMapping("/appointment")
    public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
        try {
            Appointment returnedAppointment = appointmentService.addAppointment(appointment);
            return ResponseEntity.ok(returnedAppointment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Delete appointment response entity.
     *
     * @param appointmentId the appointment id
     * @return the response entity
     */
    @DeleteMapping("/appointment")
    public ResponseEntity<String> deleteAppointment(@RequestParam String appointmentId) {
        try {
            appointmentService.deleteAppointment(appointmentId);
            return ResponseEntity.ok(appointmentId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Gets appointments.
     *
     * @param serviceId the service id
     * @return the appointments
     */
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments(@RequestParam String serviceId) {
        try {
            List<Appointment> returnedAppointments = appointmentService.getAppointments(serviceId);
            return ResponseEntity.ok(returnedAppointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Gets user appointments.
     *
     * @param userId the user id
     * @return the user appointments
     */
    @GetMapping("/user-appointments")
    public ResponseEntity<List<Appointment>> getUserAppointments(@RequestParam String userId) {
        try {
            List<Appointment> returnedAppointments = appointmentService.getUserAppointments(userId);
            return ResponseEntity.ok(returnedAppointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
