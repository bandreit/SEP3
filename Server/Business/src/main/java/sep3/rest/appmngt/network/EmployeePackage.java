package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Employee;

public class EmployeePackage extends NetworkPackage {
    private Employee employee;
    private String businessId;

    public EmployeePackage(NetworkType type, Employee employee, String businessId) {
        super(type);
        this.employee = employee;
        this.businessId = businessId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getBusinessId() {
        return businessId;
    }
}
