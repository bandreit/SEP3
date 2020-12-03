package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class ModelManager implements Model {

    private final MongoCollection<Document> usersCollection;
    private final Gson gson;

    public ModelManager(MongoDatabase database) {
        usersCollection = database.getCollection("users");
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
}
