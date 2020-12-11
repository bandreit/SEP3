package sep3.db.model;

import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

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
        newBusiness.append("businessOwnerID", new ObjectId(business.getBusinessOwnerID()));

        if (business.getLocations() != null)
        newBusiness.append("locations", business.getLocations());

        businessCollection.insertOne(newBusiness);
        String objectId = newBusiness.get("_id").toString();
        business.setId(objectId);

        return business;
    }

    @Override
    public void addEmployee(String employeeId, String businessId) {
        businessCollection.updateOne(eq("_id", new ObjectId(businessId)), Updates.addToSet("employees", new ObjectId(employeeId)));
    }

    @Override
    public void removeEmployee(String employeeId, String businessId) {
        businessCollection.updateOne(eq("_id", new ObjectId(businessId)), Updates.pull("employees", new ObjectId(employeeId)));
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
                listOfBusiness.add(fromDocumentToObject);
            }
            return listOfBusiness;
        }
        return listOfBusiness;
    }


}
