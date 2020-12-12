package sep3.db.network;

import sep3.db.model.Employee;
import sep3.db.model.Service;

import java.util.List;

public class ServiceListPackage extends NetworkPackage {
    private List<Service> serviceList;
    private String businessId;

    public ServiceListPackage(NetworkType type, List<Service> services, String businessId) {
        super(type);
        this.serviceList = services;
        this.businessId = businessId;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public String getBusinessId() {
        return businessId;
    }
}
