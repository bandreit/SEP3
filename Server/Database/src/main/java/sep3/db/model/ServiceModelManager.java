package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class ServiceModelManager implements ServiceModel {
    private final MongoCollection<Document> serviceCollection;
    private final MongoCollection<Document> businessCollection;
    private final Gson gson;

    public ServiceModelManager(MongoDatabase database) {
        serviceCollection = database.getCollection("services");
        businessCollection = database.getCollection("business");
        gson = new Gson();
    }

    @Override
    public Service addService(Service service) {
        Document newService = new Document();
        newService.append("pictureUrl", service.getPictureUrl());
        newService.append("title", service.getTitle());
        newService.append("description", service.getDescription());
        newService.append("duration", service.getDuration());
        newService.append("businessId", service.getBusinessId());

        serviceCollection.insertOne(newService);

        ObjectId generatedServiceObjectID = (ObjectId) newService.get("_id");
        service.setId(generatedServiceObjectID.toString());

        businessCollection.updateOne(eq("_id", new ObjectId(service.getBusinessId())), Updates.addToSet("services", generatedServiceObjectID));

        return service;

    }
}
