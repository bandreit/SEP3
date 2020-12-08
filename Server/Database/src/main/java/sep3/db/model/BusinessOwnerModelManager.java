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
}
