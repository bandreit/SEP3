package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class UserModelManager implements UserModel {

    private final MongoCollection<Document> usersCollection;
    private final Gson gson;

    public UserModelManager(MongoDatabase database) {
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

    @Override
    public User RegisterUser(User user) {
        Document newUser = new Document();
        newUser.append("userName", user.getUserName());
        newUser.append("password", user.getPassword());
        newUser.append("email", user.getEmail());
        newUser.append("city", user.getCity());
        newUser.append("role", user.getRole());
        newUser.append("firstName", user.getFirstName());
        newUser.append("lastName", user.getLastName());
        newUser.append("phone", user.getPhone());

        usersCollection.insertOne(newUser);

        ObjectId generatedServiceObjectID = (ObjectId) newUser.get("_id");
        user.setId(generatedServiceObjectID.toString());

        return user;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> listOfEmployees = new ArrayList<>();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("role", "Employee");
        MongoCursor<Document> cursor = usersCollection.find(whereQuery).iterator();
        while (cursor.hasNext()) {
                Document document = cursor.next();
                Employee fromDocumentToObject = gson.fromJson(document.toJson(), Employee.class);
                fromDocumentToObject.setId(document.get("_id").toString());
                listOfEmployees.add(fromDocumentToObject);
        }
        return listOfEmployees;
    }
}
