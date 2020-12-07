package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
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

        Business businessWithId = business;
        String objectId = newBusiness.get("_id").toString();
        businessWithId.setId(objectId);
        List<Document> businessList = new ArrayList<>();
        businessList.add(newBusiness);
//        businessList.add(new Document("business", businessWithId).append("name", businessWithId.getName()).append("location", businessWithId.getLocation()).append("mail", businessWithId.getMail()).append("service", businessWithId.getMail()));

        Document businessOwnerDatabase = businessOwnerCollection.find(eq("_id", new ObjectId(id))).first();

        businessOwnerDatabase.append("business", businessList);
        //works but not works
        System.out.println(businessOwnerDatabase.append("userName","edva"));
        System.out.println(businessOwnerDatabase.append("business",businessList) + "listarauzas");

//        businessOwnerCollection.insertMany(businessList);
        return businessWithId;
    }
}
