package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Service;

import java.util.List;

public class ServiceListPackage extends NetworkPackage {
    private List<Service> serviceList;
    private String filter;

    public ServiceListPackage(NetworkType type, List<Service> services, String filter) {
        super(type);
        this.serviceList = services;
        this.filter = filter;
    }

    public ServiceListPackage(NetworkType type, List<Service> serviceList) {
        super(type);
        this.serviceList = serviceList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public String getFilter() {
        return filter;
    }
}
