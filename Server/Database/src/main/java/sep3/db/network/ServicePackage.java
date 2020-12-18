package sep3.db.network;

import sep3.db.model.Service;

/**
 * The type Service package.
 */
public class ServicePackage extends NetworkPackage {
    private Service service;

    /**
     * Instantiates a new Service package.
     *
     * @param type    the type
     * @param service the service
     */
    public ServicePackage(NetworkType type, Service service) {
        super(type);
        this.service = service;
    }

    /**
     * Gets service.
     *
     * @return the service
     */
    public Service getService() {
        return service;
    }
}
