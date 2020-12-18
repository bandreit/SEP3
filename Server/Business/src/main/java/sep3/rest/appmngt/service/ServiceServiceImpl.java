package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

/**
 * The type Service service.
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceModel serviceModel = new ServiceImpl();


    /**
     * Instantiates a new Service service.
     *
     * @throws IOException the io exception
     */
    public ServiceServiceImpl() throws IOException {
    }

    @Override
    public void addService(Service service) throws IOException {
        serviceModel.addService(service);
    }
    /**
     * Service model calls getServices by businessId
     *
     * @param businessId String
     */
    @Override
    public List<Service> getServicesByBusinessId(String businessId) throws IOException {
        return serviceModel.getServicesByBusinessId(businessId);
    }
    /**
     * Service model calls getServices by title
     *
     * @param title String
     * @return all services by title
     */
    @Override
    public List<Service> getServiceByTitle(String title) throws IOException {
        return serviceModel.getServiceByTitle(title);
    }

    @Override
    public List<Service> getAllServices() throws IOException {
        return serviceModel.getAllServices();
    }
    /**
     * Service model calls to delete services by id
     *
     * @param serviceId String
     */
    @Override
    public void deleteService(String serviceId) throws IOException {
        serviceModel.deleteService(serviceId);
    }
}
