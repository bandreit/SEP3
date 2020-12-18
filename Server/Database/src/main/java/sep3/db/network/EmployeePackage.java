package sep3.db.network;

import sep3.db.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Employee package.
 */
public class EmployeePackage extends NetworkPackage {
    private List<String>  employeeIds;
    private String employeeId;
    private String businessId;
    private String serviceId;

    /**
     * Instantiates a new Employee package.
     *
     * @param type       the type
     * @param employee   the employee
     * @param businessId the business id
     * @param serviceId  the service id
     */
    public EmployeePackage(NetworkType type, List<String>  employee, String businessId, String serviceId) {
        super(type);
        this.employeeIds = employee;
        this.businessId = businessId;
        this.serviceId = serviceId;
    }

    /**
     * Instantiates a new Employee package.
     *
     * @param type       the type
     * @param employee   the employee
     * @param businessId the business id
     */
    public EmployeePackage(NetworkType type, String employee, String businessId) {
        super(type);
        this.employeeId = employee;
        this.businessId = businessId;
    }

    /**
     * Gets employee ids.
     *
     * @return the employee ids
     */
    public List<String>  getEmployeeIds() {
        return employeeIds;
    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Gets business id.
     *
     * @return the business id
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * Gets service id.
     *
     * @return the service id
     */
    public String getServiceId() {
        return serviceId;
    }
}