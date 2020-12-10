package sep3.rest.appmngt.model;

import java.io.IOException;

public interface BusinessModel {
    Business addBusiness(Business business,String id) throws IOException;
    Service addService(Service service, String id) throws IOException;
    Employee addEmployee(Employee employee, String businessId) throws IOException;

}
