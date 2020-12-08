package sep3.db.network;

import sep3.db.model.Employee;

public class EmployeePackage extends NetworkPackage {
    private Employee employee;
    private String employeeId;

    public EmployeePackage(NetworkType type, Employee employee, String employeeId) {
        super(type);
        this.employee = employee;
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
