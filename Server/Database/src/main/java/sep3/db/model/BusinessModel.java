package sep3.db.model;

import org.bson.Document;

import java.io.IOException;
import java.util.List;

public interface BusinessModel {
    Business addBusiness(Business business);
    Service addService(Service service, String id);
    Employee addEmployee(Employee employee, String businessId);
    void removeEmployee(String id);
    public List<Business> getOwnedBusinesses(String businessOwnerId)throws IOException;
    public List<Business> getAllBusiness() throws IOException;
}
