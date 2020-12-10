package sep3.rest.appmngt.network;


import sep3.rest.appmngt.model.Service;

public class ServicePackage extends NetworkPackage {
    private Service service;

    public ServicePackage(NetworkType type, Service service) {
        super(type);
        this.service = service;
    }

    public Service getService() {
        return service;
    }
}
