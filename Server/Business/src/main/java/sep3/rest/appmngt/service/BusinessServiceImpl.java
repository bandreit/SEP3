package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    private final BusinessModel businessModel = new BusinessModelImpl();

    public BusinessServiceImpl() throws IOException {
    }

    @Override
    public Business addBusiness(Business business) throws IOException {
        return businessModel.addBusiness(business);
    }

    @Override
    public sep3.rest.appmngt.model.Service addService(sep3.rest.appmngt.model.Service service, String id) throws IOException {
        return businessModel.addService(service, id);
    }

    @Override
    public Employee addEmployee(Employee employee, String businessId) throws IOException {
        return businessModel.addEmployee(employee, businessId);
    }

    @Override
    public List<Business> getAllBusiness() throws IOException {
        return businessModel.getAllBusiness();
    }

    @Override
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException {
        return businessModel.getOwnedBusinesses(businessOwnerId);
    }
}
