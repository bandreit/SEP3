package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

/**
 * The type Business service.
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    private final BusinessModel businessModel = new BusinessModelImpl();

    /**
     * Instantiates a new Business service.
     *
     * @throws IOException the io exception
     */
    public BusinessServiceImpl() throws IOException {
    }


    /**
     * Business model calls to add business
     *
     * @param business Business
     */
    @Override
    public Business addBusiness(Business business) throws IOException {
       return businessModel.addBusiness(business);
    }

    /**
     * Business model calls to add employee
     *
     * @param employeeId List of Strings
     * @param businessId String
     * @param serviceId String
     */

    @Override
    public void addEmployee(List<String>  employeeId, String businessId, String serviceId) throws IOException {
        businessModel.addEmployee(employeeId, businessId, serviceId);
    }
    /**
     * Business model calls to remove employee by id
     *
     * @param employeeId String
     * @param businessId String
     */
    @Override
    public void removeEmployee(String employeeId, String businessId) throws IOException {
        businessModel.removeEmployee(employeeId, businessId);
    }

    /**
     * Business model calls to get all businesses
     * @return all  businesses
     */
    @Override
    public List<Business> getAllBusiness() throws IOException {
        return businessModel.getAllBusiness();
    }
    /**
     * Business model calls to get owned businesses
     * @param businessOwnerId String
     * @return all owned businesses
     */

    @Override
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException {
        return businessModel.getOwnedBusinesses(businessOwnerId);
    }
    /**
     * Business model calls to get business by id
     * @param id String
     * @return all businesses by id
     */
    @Override
    public Business getBusinessById(String id) throws IOException {
        return businessModel.getBusinessById(id);
    }
    /**
     * Business model calls to edit business
     * @param business Business
     */
    @Override
    public void editBusiness(Business business) throws IOException {
        businessModel.editBusiness(business);
    }
}
