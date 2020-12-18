package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * The type Appointment model manager.
 */
public class AppointmentModelManager implements AppointmentModel {
    private final MongoCollection<Document> appointmentCollection;
    private final Gson gson;

    /**
     * Instantiates a new Appointment model manager.
     *
     * @param database the database
     */
    public AppointmentModelManager(MongoDatabase database) {
        appointmentCollection = database.getCollection("appointments");
        gson = new Gson();
    }
    /**
     * Add new appointment to the database
     *
     * @param appointment the appointment
     * @return appointment;
     */
    @Override
    public Appointment addAppointment(Appointment appointment) {
        Document newAppointment = new Document();
        newAppointment.append("serviceId", appointment.getServiceId());
        newAppointment.append("scheduledTime", appointment.getScheduledTime());
        newAppointment.append("createdBy", appointment.getCreatedBy());
        newAppointment.append("serviceName", appointment.getServiceName());
        newAppointment.append("selectedEmployeeId", appointment.getSelectedEmployeeId());

        BasicDBObject locationDoc = new BasicDBObject();
        locationDoc.put("streetNumber", appointment.getSelectedLocation().getStreetNumber());
        locationDoc.put("streetName", appointment.getSelectedLocation().getStreetName());

        newAppointment.append("selectedLocation", locationDoc);

        appointmentCollection.insertOne(newAppointment);

        String objectId = newAppointment.get("_id").toString();
        appointment.setId(objectId);
        return appointment;
    }
    /**
     * Gets all appointments from the database by serviceId to the list
     *
     * @param serviceId String
     * @return the appointments
     */
    @Override
    public List<Appointment> getAppointments(String serviceId) {
        List<Appointment> listOfAppointments = new ArrayList<>();
        MongoCursor<Document> cursor = appointmentCollection.find(eq("serviceId", serviceId)).iterator();

        while(cursor.hasNext()) {
            Document document = cursor.next();
            Appointment fromDocumentToObject = gson.fromJson(document.toJson(), Appointment.class);
            fromDocumentToObject.setId(document.get("_id").toString());

            listOfAppointments.add(fromDocumentToObject);
        }

        return listOfAppointments;
    }
    /**
     * Gets all users appointments by his id
     *
     * @param userId String
     * @return the appointments
     */
    @Override
    public List<Appointment> getUserAppointments(String userId) {
        List<Appointment> listOfAppointments = new ArrayList<>();
        MongoCursor<Document> cursor = appointmentCollection.find(eq("createdBy", userId)).iterator();

        while(cursor.hasNext()) {
            Document document = cursor.next();
            Appointment fromDocumentToObject = gson.fromJson(document.toJson(), Appointment.class);
            fromDocumentToObject.setId(document.get("_id").toString());

            listOfAppointments.add(fromDocumentToObject);
        }

        return listOfAppointments;
    }
    /**
     * Delets appointment by  appointmentId
     *
     * @param appointmentId String
     * @return deleted appointment
     */
    @Override
    public String deleteAppointment(String appointmentId) {
        appointmentCollection.deleteOne(new Document("_id", new ObjectId(appointmentId)));
        return appointmentId;
    }
}
