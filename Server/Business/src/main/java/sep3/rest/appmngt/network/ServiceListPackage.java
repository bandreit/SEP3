package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Service;

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
