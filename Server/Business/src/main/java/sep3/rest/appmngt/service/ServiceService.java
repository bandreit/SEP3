package sep3.rest.appmngt.service;


import sep3.rest.appmngt.model.Service;

import java.io.IOException;
import java.util.List;

/**
 * The interface Service service.
 */
public interface ServiceService {
    /**
     * Add service.
     *
     * @param service the service
     * @throws IOException the io exception
     */
    void addService(Service service) throws IOException;

    /**
     * Gets services by business id.
     *
     * @param businessId the business id
     * @return the services by business id
     * @throws IOException the io exception
     */
    List<Service> getServicesByBusinessId(String businessId) throws IOException;

    /**
     * Gets service by title.
     *
     * @param title the title
     * @return the service by title
     * @throws IOException the io exception
     */
    List<Service> getServiceByTitle(String title) throws IOException;

    /**
     * Gets all services.
     *
     * @return the all services
     * @throws IOException the io exception
     */
    List<Service> getAllServices() throws IOException;

    /**
     * Delete service.
     *
     * @param serviceId the service id
     * @throws IOException the io exception
     */
    void deleteService(String serviceId) throws IOException;
}
