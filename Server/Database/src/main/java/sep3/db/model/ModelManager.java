package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class ModelManager implements Model{

    private final MongoCollection<Document> usersCollection;

    public ModelManager(MongoDatabase database) {
        usersCollection = database.getCollection("users");
    }

    @Override
    public User ValidateUser(String userName, String password) {
        {
            if (usersCollection.find(eq("userName", userName)).first() != null) {
                Document user = usersCollection.find(eq("userName", userName)).first();
                System.out.println(user.toJson());
                Gson gson = new Gson();
                return gson.fromJson(user.toJson(), User.class);
            }

            return null;
        }
    }
}
