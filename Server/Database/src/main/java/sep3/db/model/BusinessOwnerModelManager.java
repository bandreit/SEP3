package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class BusinessOwnerModelManager implements BusinessOwnerModel {
    private final MongoCollection<Document> businessOwnerCollection;
    private final Gson gson;


    public BusinessOwnerModelManager(MongoDatabase database) {
        businessOwnerCollection = database.getCollection("businessowner");
        gson = new Gson();
    }

    @Override
    public BusinessOwner getBusinessOwner(String id) {
        if (businessOwnerCollection.find(eq("_id", new ObjectId(id))).first() != null) {
            Document businessOwner = businessOwnerCollection.find(eq("_id", new ObjectId(id))).first();
            BusinessOwner businessOwnerWithId = gson.fromJson(businessOwner.toJson(), BusinessOwner.class);
            String objectId = businessOwner.get("_id").toString();
            businessOwnerWithId.setId(objectId);
            return businessOwnerWithId;
        }
        return null;
    }

    @Override
    public BusinessOwner addBusinessOwner(BusinessOwner businessOwner) {
        Document newBusinessOwner = new Document();
        newBusinessOwner.append("firstName",businessOwner.getFirstName());
        newBusinessOwner.append("lastName", businessOwner.getLastName());
        newBusinessOwner.append("userName", businessOwner.getUserName());
        newBusinessOwner.append("password", businessOwner.getPassword());
        newBusinessOwner.append("city", businessOwner.getCity());
        newBusinessOwner.append("email", businessOwner.getEmail());
        newBusinessOwner.append("phone", businessOwner.getPhone());


        businessOwnerCollection.insertOne(newBusinessOwner);

        BusinessOwner businessWithId = businessOwner;
        String objectId = newBusinessOwner.get("_id").toString();
        businessWithId.setId(objectId);
        return businessWithId;
    }
}
