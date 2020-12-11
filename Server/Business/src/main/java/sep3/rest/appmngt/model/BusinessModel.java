package sep3.rest.appmngt.model;

import java.io.IOException;
import java.util.List;

public interface BusinessModel {
    Business addBusiness(Business business) throws IOException;

    Service addService(Service service, String id) throws IOException;

    Employee addEmployee(Employee employee, String businessId) throws IOException;

    List<Business> getAllBusiness() throws IOException;
}
