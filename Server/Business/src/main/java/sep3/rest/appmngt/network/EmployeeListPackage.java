package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.User;

import java.util.List;

/**
 * The type Employee list package.
 */
public class EmployeeListPackage extends NetworkPackage {
    private List<Employee> employeeList;

    /**
     * Instantiates a new Employee list package.
     *
     * @param type      the type
     * @param employees the employees
     */
    public EmployeeListPackage(NetworkType type, List<Employee> employees) {
        super(type);
        this.employeeList = employees;
    }

    /**
     * Gets employee list.
     *
     * @return the employee list
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
