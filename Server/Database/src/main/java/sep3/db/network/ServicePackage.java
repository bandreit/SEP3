package sep3.db.network;

import sep3.db.model.Service;

public class ServicePackage extends NetworkPackage {
    private Service service;
    private String serviceId;

    public ServicePackage(NetworkType type, Service service, String serviceId) {
        super(type);
        this.service = service;
        this.serviceId = serviceId;
    }

    public Service getService() {
        return service;
    }

    public String getServiceId() {
        return serviceId;
    }
}
