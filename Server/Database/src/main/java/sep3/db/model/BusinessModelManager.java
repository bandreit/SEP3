package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class BusinessModelManager implements BusinessModel {


    private final MongoCollection<Document> businessCollection;
    private final MongoCollection<Document> businessOwnerCollection;
    private final Gson gson;

    public BusinessModelManager(MongoDatabase database) {
        businessCollection = database.getCollection("business");
        businessOwnerCollection = database.getCollection("businessowner");
        gson = new Gson();
    }

    @Override
    public Business addBusiness(Business business, String id) {
        Document newBusiness = new Document();
        newBusiness.append("name", business.getName());
        newBusiness.append("location", business.getLocation());
        newBusiness.append("mail", business.getMail());
        newBusiness.append("service", business.getService());

        businessCollection.insertOne(newBusiness);

        String objectId = newBusiness.get("_id").toString();
        business.setId(objectId);
        businessOwnerCollection.updateOne(eq("_id", new ObjectId(id)), Updates.addToSet("business", newBusiness.get("_id")));
        return business;
    }
}
