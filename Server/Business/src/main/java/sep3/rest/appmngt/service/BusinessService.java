package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.Service;

import java.io.IOException;

public interface BusinessService {
    Business addBusiness(Business business,String id) throws IOException;
    Service addService(Service service, String id) throws IOException;
    Employee addEmployee(Employee employee, String businessId) throws IOException;
}
