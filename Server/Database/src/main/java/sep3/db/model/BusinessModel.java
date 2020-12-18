package sep3.db.model;

import org.bson.Document;

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
     * @return the business
     */
    Business addBusiness(Business business);

    /**
     * Add employee.
     *
     * @param employeeIds the employee ids
     * @param businessId  the business id
     * @param serviceId   the service id
     */
    void addEmployee(List<String>  employeeIds, String businessId, String serviceId);

    /**
     * Remove employee.
     *
     * @param employeeId the employee id
     * @param businessId the business id
     */
    void removeEmployee(String employeeId, String businessId);

    /**
     * Gets all business.
     *
     * @return the all business
     * @throws IOException the io exception
     */
     List<Business> getAllBusiness() throws IOException;

    /**
     * Edit business.
     *
     * @param business the business
     */
    void editBusiness(Business business);
}
