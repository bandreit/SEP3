package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class BusinessModelManager implements BusinessModel {


    private final MongoCollection<Document> businessCollection;
    private final MongoCollection<Document> businessOwnerCollection;
    private final MongoCollection<Document> serviceCollection;
    private final MongoCollection<Document> employeeCollection;
    private final Gson gson;

    public BusinessModelManager(MongoDatabase database) {
        businessCollection = database.getCollection("business");
        businessOwnerCollection = database.getCollection("businessowner");
        serviceCollection = database.getCollection("service");
        employeeCollection = database.getCollection("employee");
        gson = new Gson();
    }

    @Override
    public Business addBusiness(Business business, String id) {
        Document newBusiness = new Document();
        newBusiness.append("name", business.getName());
        newBusiness.append("location", business.getLocation());
        newBusiness.append("mail", business.getMail());
        for (Service service:business.getServices())
             {
                 Document newService = new Document();
                 newService.append("name", service.getName());
                 newService.append("duration", service.getDuration());
                 newBusiness.append("services", newService);
        }
        for (Employee employee:business.getEmployees())
        {
            Document newEmployee = new Document();
            newEmployee.append("userName", employee.getUserName());
            newEmployee.append("password", employee.getPassword());
            newEmployee.append("domain", employee.getDomain());
            newEmployee.append("city", employee.getCity());
            newEmployee.append("role", employee.getRole());
            newBusiness.append("employees", newEmployee);
        }
        businessCollection.insertOne(newBusiness);
        String objectId = newBusiness.get("_id").toString();
        business.setId(objectId);
        businessOwnerCollection.updateOne(eq("_id", new ObjectId(id)), Updates.addToSet("business", newBusiness.get("_id")));


        return business;
    }

    @Override
    public Service addService(Service service, String id) {
        Document newService = new Document();
        newService.append("name", service.getName());
        newService.append("duration", service.getDuration());
        businessCollection.updateOne(eq("_id", new ObjectId(id)), Updates.addToSet("service", service));
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee, String businessId, String serviceId) {
        return null;
    }

    @Override
    public void removeEmployee(String id) {

    }
}
