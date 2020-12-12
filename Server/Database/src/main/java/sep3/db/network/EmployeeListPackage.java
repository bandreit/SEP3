package sep3.db.network;

import sep3.db.model.Employee;
import sep3.db.model.User;

import java.util.List;

public class EmployeeListPackage extends NetworkPackage {
    private List<Employee> employeeList;

    public EmployeeListPackage(NetworkType type, List<Employee> employees) {
        super(type);
        this.employeeList = employees;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
