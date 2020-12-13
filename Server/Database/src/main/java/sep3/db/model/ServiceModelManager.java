package sep3.db.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

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
        newService.append("_businessId", new ObjectId(service.getBusinessId()));

        serviceCollection.insertOne(newService);

        ObjectId generatedServiceObjectID = (ObjectId) newService.get("_id");
        service.setId(generatedServiceObjectID.toString());

        businessCollection.updateOne(eq("_id", new ObjectId(service.getBusinessId())), Updates.addToSet("services", generatedServiceObjectID));

        return service;
    }

    @Override
    public List<Service> getServicesByBusinessId(String businessId) {
        List<Service> serviceList = new ArrayList<>();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("_businessId", new ObjectId(businessId));
        MongoCursor<Document> cursor = serviceCollection.find(whereQuery).iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            Service fromDocumentToObject = gson.fromJson(document.toJson(), Service.class);
            fromDocumentToObject.setId(document.get("_id").toString());
            fromDocumentToObject.setBusinessId(document.get("_businessId").toString());
            serviceList.add(fromDocumentToObject);
        }
        return serviceList;
    }
}
