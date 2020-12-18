package sep3.db.model;

import java.util.List;

/**
 * The interface Service model.
 */
public interface ServiceModel {
    /**
     * Add service service.
     *
     * @param service the service
     * @return the service
     */
    Service addService(Service service);

    /**
     * Gets services by business id.
     *
     * @param businessId the business id
     * @return the services by business id
     */
    List<Service> getServicesByBusinessId(String businessId);

    /**
     * Gets service by title.
     *
     * @param title the title
     * @return the service by title
     */
    List<Service> getServiceByTitle(String title);

    /**
     * Gets all services.
     *
     * @return the all services
     */
    List<Service> getAllServices();

    /**
     * Delete service.
     *
     * @param serviceId the service id
     */
    void deleteService(String serviceId);
}
