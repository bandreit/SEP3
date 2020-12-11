package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.Service;

import java.io.IOException;
import java.util.List;

public interface BusinessService {
    Business addBusiness(Business business) throws IOException;

    void addEmployee(String employeeId, String businessId) throws IOException;

    List<Business> getAllBusiness() throws IOException;

    List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException;
}
