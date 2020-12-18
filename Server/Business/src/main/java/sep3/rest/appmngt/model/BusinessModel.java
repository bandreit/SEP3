package sep3.rest.appmngt.model;

import java.io.IOException;
import java.util.List;

/**
 * The interface Business model.
 */
public interface BusinessModel {
    /**
     * Add business business.
     *
     * @param business the business
     * @throws IOException the io exception
     */
    void addBusiness(Business business) throws IOException;

    /**
     * Add employee.
     *
     * @param employeeId the employee id
     * @param businessId the business id
     * @param serviceId  the service id
     * @throws IOException the io exception
     */
    void addEmployee(List<String> employeeId, String businessId, String serviceId) throws IOException;

    /**
     * Remove employee.
     *
     * @param employeeId the employee id
     * @param businessId the business id
     * @throws IOException the io exception
     */
    void removeEmployee(String employeeId, String businessId) throws IOException;

    /**
     * Gets all business.
     *
     * @return the all business
     * @throws IOException the io exception
     */
    List<Business> getAllBusiness() throws IOException;

    /**
     * Gets owned businesses.
     *
     * @param businessOwnerId the business owner id
     * @return the owned businesses
     * @throws IOException the io exception
     */
    List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException;

    /**
     * Gets business by id.
     *
     * @param id the id
     * @return the business by id
     * @throws IOException the io exception
     */
    Business getBusinessById(String id) throws IOException;

    /**
     * Edit business.
     *
     * @param business the business
     * @throws IOException the io exception
     */
    void editBusiness(Business business) throws IOException;
}
