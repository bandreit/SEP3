package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class ModelManager implements Model {

    private final MongoCollection<Document> usersCollection;
    private final MongoCollection<Document> businessOwnerCollection;
    private final Gson gson;

    public ModelManager(MongoDatabase database) {
        usersCollection = database.getCollection("users");
        businessOwnerCollection = database.getCollection("businessowner");
        gson = new Gson();
    }

    @Override
    public User ValidateUser(String userName, String password) {
        {
            if (usersCollection.find(eq("userName", userName)).first() != null) {
                Document user = usersCollection.find(eq("userName", userName)).first();
                User userWithId = gson.fromJson(user.toJson(), User.class);
                // this gets the id from the json object and save it to the new user object, as the ID changes on deserialization
                String objectId = user.get("_id").toString();
                userWithId.setId(objectId);
                return userWithId;
            }
            return null;
        }
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
