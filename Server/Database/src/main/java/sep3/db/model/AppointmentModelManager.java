package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class AppointmentModelManager implements AppointmentModel {
    private final MongoCollection<Document> appointmentCollection;
    private final Gson gson;

    public AppointmentModelManager(MongoDatabase database) {
        appointmentCollection = database.getCollection("appointments");
        gson = new Gson();
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        Document newAppointment = new Document();
        newAppointment.append("serviceId", appointment.getServiceId());
        newAppointment.append("scheduledTime", appointment.getScheduledTime());
        newAppointment.append("name", appointment.getName());
        newAppointment.append("email", appointment.getEmail());
        newAppointment.append("phone", appointment.getPhone());
        newAppointment.append("selectedLocation", appointment.getSelectedLocation());
        newAppointment.append("selectedEmployeeId", appointment.getSelectedEmployeeId());

        appointmentCollection.insertOne(newAppointment);

        String objectId = newAppointment.get("_id").toString();
        appointment.setId(objectId);

        return null;
    }

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
}
