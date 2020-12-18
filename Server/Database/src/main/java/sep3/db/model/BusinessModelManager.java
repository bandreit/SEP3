package sep3.db.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.xml.sax.Locator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

/**
 * The type Business model manager.
 */
public class BusinessModelManager implements BusinessModel {


    private final MongoCollection<Document> businessCollection;
    private final MongoCollection<Document> employeeCollection;
    private final Gson gson;

    /**
     * Instantiates a new Business model manager.
     *
     * @param database the database
     */
    public BusinessModelManager(MongoDatabase database) {
        businessCollection = database.getCollection("business");
        employeeCollection = database.getCollection("users");
        gson = new Gson();
    }
    /**
     * Adds business to database
     *
     * @param business the business
     * @return business
     */
    @Override
    public Business addBusiness(Business business) {
        Document newBusiness = new Document();
        newBusiness.append("name", business.getName());
        newBusiness.append("mail", business.getMail());
        newBusiness.append("businessOwnerID", new ObjectId(business.getBusinessOwnerID()));

        BasicDBList listOfLocations = new BasicDBList();
        if (business.getLocations() != null) {
            for (Location location : business.getLocations()) {
                Document newLocation = new Document();
                newLocation.put("streetNumber", location.getStreetNumber());
                newLocation.put("streetName", location.getStreetName());
                listOfLocations.add(newLocation);
            }
        }

        newBusiness.append("locations", listOfLocations);

        if (business.getEmployees() != null) {

            newBusiness.append("employees", business.getEmployees());
        }

        if (business.getServices() != null) {

            newBusiness.append("services", business.getServices());
        }

        businessCollection.insertOne(newBusiness);
        String objectId = newBusiness.get("_id").toString();
        business.setId(objectId);
        return business;
    }
    /**
     * Adds employee to the business
     *
     * @param employeeIds list of Strings
     * @param businessId  String
     * @param serviceId   String
     */
    @Override
    public void addEmployee(List<String>  employeeIds, String businessId, String serviceId) {
        for (String employeeId : employeeIds) {
            businessCollection.updateOne(eq("_id", new ObjectId(businessId)), Updates.addToSet("employees", new ObjectId(employeeId)));
        }

        for (String employeeId : employeeIds) {
            employeeCollection.updateOne(eq("_id", new ObjectId(employeeId)), Updates.addToSet("serviceIdList", new ObjectId(serviceId)));
        }
    }
    /**
     * remove employee from the business by employeeId
     *
     * @param employeeId  String
     * @param businessId  String
     *
     */
    @Override
    public void removeEmployee(String employeeId, String businessId) {
        businessCollection.updateOne(eq("_id", new ObjectId(businessId)), Updates.pull("employees", new ObjectId(employeeId)));
    }

    /**
     * Gets all businesses from database
     * @return the businesses
     */
    @Override
    public List<Business> getAllBusiness() throws IOException {
        List<Business> listOfBusiness = new ArrayList<>();
        MongoCursor<Document> cursor = businessCollection.find().iterator();

        if (businessCollection.find().first() != null) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Gson gson = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create();
                Business fromDocumentToObject = gson.fromJson(document.toJson(), Business.class);
                fromDocumentToObject.setBusinessOwnerID(document.get("businessOwnerID").toString());
                fromDocumentToObject.setId(document.get("_id").toString());
                List<String> serviceIds = new ArrayList<>();
                List<String> employeeIds = new ArrayList<>();
                List<Location> locations = new ArrayList<>();

                for (ObjectId serviceId : (List<ObjectId>) document.get("services")) {
                    serviceIds.add(serviceId.toString());
                }

                for (ObjectId employeeId : (List<ObjectId>) document.get("employees")) {
                    employeeIds.add(employeeId.toString());
                }

                List<Document> objs = (List<Document>) document.get("locations");

                for (Document locationDocument : objs) {
                    Location location = new Location(locationDocument.get("streetNumber").toString(), locationDocument.get("streetName").toString());
                    locations.add(location);
                }

                fromDocumentToObject.setLocations(locations);
                fromDocumentToObject.setServices(serviceIds);
                fromDocumentToObject.setEmployees(employeeIds);
                listOfBusiness.add(fromDocumentToObject);
            }
            return listOfBusiness;
        }
        return listOfBusiness;
    }
    /**
     * Edit the specific business
     *
     * @param business Business
     */
    @Override
    public void editBusiness(Business business) {
        Document query = new Document();
        query.append("_id", new ObjectId(business.getId()));
        Document editedBusiness = new Document();
        editedBusiness.append("name", business.getName());
        editedBusiness.append("mail", business.getMail());

        BasicDBList locations = new BasicDBList();
        if (business.getLocations() != null) {
            for (Location location : business.getLocations()) {
                Document newLocation = new Document();
                newLocation.put("streetNumber", location.getStreetNumber());
                newLocation.put("streetName", location.getStreetName());
                locations.add(newLocation);
            }
        }

        editedBusiness.append("locations", locations);
        Document update = new Document();
        update.append("$set", editedBusiness);
        businessCollection.updateOne(query, update);
    }

}
