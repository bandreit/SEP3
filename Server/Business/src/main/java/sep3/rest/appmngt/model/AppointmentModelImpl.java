package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModelImpl implements AppointmentModel {
    private final ConnectionHandler connectionManager;
    private final Gson gson;

    public AppointmentModelImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public Appointment addAppointment(Appointment appointment) throws IOException {
        BookAppointmentPackage bookAppointmentPackage = new BookAppointmentPackage(NetworkType.BOOK_APPOINTMENT, appointment);
        String data = gson.toJson(bookAppointmentPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        bookAppointmentPackage = gson.fromJson(receivedData, BookAppointmentPackage.class);

        return bookAppointmentPackage.getAppointment();
    }

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

    @Override
    public List<Appointment> getUserAppointments(String userId) throws IOException {
        List<Appointment> appointmentList = new ArrayList<>();
        UserAppointmentListPackage appointmentListPackage = new UserAppointmentListPackage(NetworkType.LIST_USER_APPOINTMENTS, userId, appointmentList);
        String data = gson.toJson(appointmentListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        appointmentListPackage = gson.fromJson(receivedData, UserAppointmentListPackage.class);


        return appointmentListPackage.getAppointments();
    }
}
