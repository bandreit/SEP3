package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ServiceModelManager implements ServiceModel {
    private final MongoCollection<Document> serviceCollection;
    private final Gson gson;

    public ServiceModelManager(MongoDatabase database) {
        serviceCollection = database.getCollection("services");
        gson = new Gson();
    }

    @Override
    public Service addService(Service service) {
        Document newService = new Document();
        newService.append("pictureUrl", service.getPictureUrl());
        newService.append("title", service.getTitle());
        newService.append("description", service.getDescription());
        newService.append("duration", service.getDuration());

        serviceCollection.insertOne(newService);

        Service serviceWithId = service;
        String objectId = newService.get("_id").toString();
        serviceWithId.setId(objectId);

        return serviceWithId;

    }
}
