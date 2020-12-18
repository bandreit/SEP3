package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Appointment model.
 */
public class AppointmentModelImpl implements AppointmentModel {
    private final ConnectionHandler connectionManager;
    private final Gson gson;

    /**
     * Instantiates a new Appointment model.
     *
     * @throws IOException the io exception
     */
    public AppointmentModelImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }
    /**
     * Adding appointment and  exchanging appointment data with database
     *
     * @param appointment Appointment
     * @return appointments
     */
    @Override
    public Appointment addAppointment(Appointment appointment) throws IOException {
        BookAppointmentPackage bookAppointmentPackage = new BookAppointmentPackage(NetworkType.BOOK_APPOINTMENT, appointment);
        String data = gson.toJson(bookAppointmentPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        bookAppointmentPackage = gson.fromJson(receivedData, BookAppointmentPackage.class);

        return bookAppointmentPackage.getAppointment();
    }
    /**
     * Getting  appointments by service id and exchanging appointment list data with database
     *
     * @param serviceId String
     * @return appointments
     */
    @Override
    public List<Appointment> getAppointments(String serviceId) throws IOException {
        List<Appointment> appointmentList = new ArrayList<>();
        AppointmentListPackage appointmentListPackage = new AppointmentListPackage(NetworkType.LIST_APPOINTMENTS, serviceId, appointmentList);
        String data = gson.toJson(appointmentListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        appointmentListPackage = gson.fromJson(receivedData, AppointmentListPackage.class);


        return appointmentListPackage.getAppointments();
    }

    /**
     * Getting users  appointments by id and exchanging appointment list data with database
     *
     * @param userId String
     * @return appointments
     */
    @Override
    public List<Appointment> getUserAppointments(String userId) throws IOException {
        List<Appointment> appointmentList = new ArrayList<>();
        UserAppointmentListPackage appointmentListPackage = new UserAppointmentListPackage(NetworkType.USER_LIST_APPOINTMENTS, userId, appointmentList);
        String data = gson.toJson(appointmentListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        appointmentListPackage = gson.fromJson(receivedData, UserAppointmentListPackage.class);


        return appointmentListPackage.getAppointments();
    }
    /**
     * Deleting appointment by id and exchanging appointmentId data with database
     *
     * @param appointmentId String
     * @return appointments
     */
    @Override
    public String deleteAppointment(String appointmentId) throws IOException {
        DeleteAppointmentPackage deleteAppointmentPackage = new DeleteAppointmentPackage(NetworkType.DELETE_APPOINTMENT, appointmentId);
        String data = gson.toJson(deleteAppointmentPackage);
        connectionManager.sendToServer(data);
        connectionManager.readFromServer();

        return appointmentId;
    }
}
