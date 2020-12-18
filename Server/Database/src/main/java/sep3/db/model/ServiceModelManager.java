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

/**
 * The type Service model manager.
 */
public class ServiceModelManager implements ServiceModel {
    private final MongoCollection<Document> serviceCollection;
    private final MongoCollection<Document> businessCollection;
    private final Gson gson;

    /**
     * Instantiates a new Service model manager.
     *
     * @param database the database
     */
    public ServiceModelManager(MongoDatabase database) {
        serviceCollection = database.getCollection("services");
        businessCollection = database.getCollection("business");
        gson = new Gson();
    }
    /**
     * Adds services to database
     *
     * @param service Service
     * @return added service
     */
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
    /**
     * Gets businesses from database by id
     *
     * @param businessId String
     * @return the services
     */
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
    /**
     * Gets businesses from database by title
     *
     * @param title String
     * @return the services
     */
    @Override
    public List<Service> getServiceByTitle(String title) {
        List<Service> serviceList = new ArrayList<>();
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("title", title);
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
    /**
     * Gets all businesses
     * @return the services
     */
    @Override
    public List<Service> getAllServices() {
        List<Service> serviceList = new ArrayList<>();
        MongoCursor<Document> cursor = serviceCollection.find().iterator();
        if (serviceCollection.find().first() != null) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Service fromDocumentToObject = gson.fromJson(document.toJson(), Service.class);
                fromDocumentToObject.setId(document.get("_id").toString());
                fromDocumentToObject.setBusinessId(document.get("_businessId").toString());
                serviceList.add(fromDocumentToObject);
            }
            return serviceList;
        }
        return serviceList;
    }
    /**
     * Deletes services by id
     * @param serviceId String
     */
    @Override
    public void deleteService(String serviceId) {
        serviceCollection.deleteOne(new Document("_id", new ObjectId(serviceId)));
    }
}
