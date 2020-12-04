package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;
import org.bson.types.ObjectId;

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
        newBusiness.append("location", business.getLocation());
        newBusiness.append("mail", business.getMail());
        newBusiness.append("service", business.getService());


        businessCollection.insertOne(newBusiness);

        Business businessWithId = business;
        String objectId = newBusiness.get("_id").toString();
        businessWithId.setId(objectId);
        return businessWithId;
    }
}
