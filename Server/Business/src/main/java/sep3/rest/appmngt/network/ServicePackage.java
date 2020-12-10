package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Service;

public class ServicePackage extends NetworkPackage {
    private Service service;
    private String businessId;

    public ServicePackage(NetworkType type, Service service, String serviceId) {
        super(type);
        this.service = service;
        this.businessId = serviceId;
    }

    public Service getService() {
        return service;
    }

    public String getBusinessId() {
        return businessId;
    }
}
