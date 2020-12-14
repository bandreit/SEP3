package sep3.rest.appmngt.model;

import java.io.IOException;
import java.util.List;

public interface BusinessModel {
    Business addBusiness(Business business) throws IOException;

    void addEmployee(String employeeId, String businessId) throws IOException;

    void removeEmployee(String employeeId, String businessId) throws IOException;

    List<Business> getAllBusiness() throws IOException;
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException;
}
