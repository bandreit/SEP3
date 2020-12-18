package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Service;

import java.util.List;

/**
 * The type Service list package.
 */
public class ServiceListPackage extends NetworkPackage {
    private List<Service> serviceList;
    private String filter;

    /**
     * Instantiates a new Service list package.
     *
     * @param type     the type
     * @param services the services
     * @param filter   the filter
     */
    public ServiceListPackage(NetworkType type, List<Service> services, String filter) {
        super(type);
        this.serviceList = services;
        this.filter = filter;
    }

    /**
     * Instantiates a new Service list package.
     *
     * @param type        the type
     * @param serviceList the service list
     */
    public ServiceListPackage(NetworkType type, List<Service> serviceList) {
        super(type);
        this.serviceList = serviceList;
    }

    /**
     * Gets service list.
     *
     * @return the service list
     */
    public List<Service> getServiceList() {
        return serviceList;
    }

    /**
     * Gets filter.
     *
     * @return the filter
     */
    public String getFilter() {
        return filter;
    }
}
