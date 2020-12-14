package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Employee;

public class EmployeePackage extends NetworkPackage {
    private String employeeId;
    private String businessId;
    private String serviceId;

    public EmployeePackage(NetworkType type, String employee, String businessId, String serviceId) {
        super(type);
        this.employeeId = employee;
        this.businessId = businessId;
        this.serviceId = serviceId;
    }

    public EmployeePackage(NetworkType type, String employee, String businessId) {
        super(type);
        this.employeeId = employee;
        this.businessId = businessId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public String getServiceId() {
        return serviceId;
    }
}
