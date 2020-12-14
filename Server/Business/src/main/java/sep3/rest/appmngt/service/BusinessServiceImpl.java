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
    public void addEmployee(String employeeId, String businessId) throws IOException {
        businessModel.addEmployee(employeeId, businessId);
    }

    @Override
    public void removeEmployee(String employeeId, String businessId) throws IOException {
        businessModel.removeEmployee(employeeId, businessId);
    }

    @Override
    public List<Business> getAllBusiness() throws IOException {
        return businessModel.getAllBusiness();
    }

    @Override
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException {
        return businessModel.getOwnedBusinesses(businessOwnerId);
    }

    @Override
    public Business getBusinessById(String id) throws IOException {
        return businessModel.getBusinessById(id);
    }

    @Override
    public void editBusiness(Business business) throws IOException {
        businessModel.editBusiness(business);
    }
}
