package sep3.db.network;

import sep3.db.model.Employee;

import java.util.ArrayList;
import java.util.List;

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
