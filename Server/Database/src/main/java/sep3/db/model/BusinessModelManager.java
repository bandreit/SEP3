package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.xml.sax.Locator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class BusinessModelManager implements BusinessModel {


    private final MongoCollection<Document> businessCollection;
    private final Gson gson;

    public BusinessModelManager(MongoDatabase database) {
        businessCollection = database.getCollection("business");
        gson = new Gson();
    }

    @Override
    public Business addBusiness(Business business) {
        Document newBusiness = new Document();
        newBusiness.append("name", business.getName());
        newBusiness.append("mail", business.getMail());
        newBusiness.append("businessOwnerID", new ObjectId(business.get_businessOwnerID()));

        if (business.getLocations() != null)
        newBusiness.append("locations", business.getLocations());

        businessCollection.insertOne(newBusiness);
        String objectId = newBusiness.get("_id").toString();
        business.setId(objectId);

        return business;
    }

    @Override
    public Service addService(Service service, String id) {
        Document newService = new Document();
        newService.append("_id", new ObjectId());
//        newService.append("name", service.getName());
        newService.append("duration", service.getDuration());
//        String objectId = newService.get("_id").toString();
//        service.setId(objectId);
        businessCollection.updateOne(eq("_id", new ObjectId(id)), Updates.addToSet("service", newService));
        return service;
    }

    @Override
    public Employee addEmployee(Employee employee, String businessId) {
        Document newEmployee = new Document();
        newEmployee.append("_id", new ObjectId());
        newEmployee.append("userName", employee.getUserName());
        newEmployee.append("password", employee.getPassword());
//        newEmployee.append("domain", employee.getDomain());
        newEmployee.append("city", employee.getCity());
        newEmployee.append("role", employee.getRole());
//        String objectId = newEmployee.get("_id").toString();
//        employee.setId(objectId);
        businessCollection.updateOne(eq("_id", new ObjectId(businessId)), Updates.addToSet("employees", newEmployee));
        return employee;
    }

    @Override
    public void removeEmployee(String id) {

    }

    @Override
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException {
        List<Business> listOfBusiness = new ArrayList<>();
        MongoCursor<Document> cursor = businessCollection.find().iterator();

        if (businessCollection.find().first() != null) {
            while (cursor.hasNext()) {
                if (cursor.next().get("_id").equals(new ObjectId(businessOwnerId))) {
                    Document document = cursor.next();
                    Business fromDocumentToObject = gson.fromJson(document.toJson(), Business.class);
                    listOfBusiness.add(fromDocumentToObject);
                }
            }
            return listOfBusiness;
        }
        return listOfBusiness;
    }

    @Override
    public List<Business> getAllBusiness() throws IOException {
        List<Business> listOfBusiness = new ArrayList<>();
        MongoCursor<Document> cursor = businessCollection.find().iterator();

        if (businessCollection.find().first() != null) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Business fromDocumentToObject = gson.fromJson(document.toJson(), Business.class);
                fromDocumentToObject.set_businessOwnerID(fromDocumentToObject.getBusinessOwnerID().toString());
                fromDocumentToObject.setId(fromDocumentToObject.get_id().toString());
                listOfBusiness.add(fromDocumentToObject);
            }
            return listOfBusiness;
        }

        return listOfBusiness;
    }


}
