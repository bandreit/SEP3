package sep3.rest.appmngt.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Employee.
 */
public class Employee extends User
{
    private List<String> serviceIdList;

    /**
     * Instantiates a new Employee.
     *
     * @param userName the user name
     * @param password the password
     */
    public Employee(String userName, String password) {
        super(userName, password);
        this.serviceIdList = new ArrayList<>();
    }

    /**
     * Gets service list.
     *
     * @return the service list
     */
    public List<String> getServiceList() {
        return serviceIdList;
    }

    /**
     * Sets service id list.
     *
     * @param serviceIdList the service id list
     */
    public void setServiceIdList(List<String> serviceIdList) {
        this.serviceIdList = serviceIdList;
    }
}
