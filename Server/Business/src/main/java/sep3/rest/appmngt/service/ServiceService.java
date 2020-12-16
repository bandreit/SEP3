package sep3.rest.appmngt.service;


import sep3.rest.appmngt.model.Service;

import java.io.IOException;
import java.util.List;

public interface ServiceService {
    void addService(Service service) throws IOException;
    List<Service> getServicesByBusinessId(String businessId) throws IOException;
    List<Service> getServiceByTitle(String title) throws IOException;
    List<Service> getAllServices() throws IOException;
    void deleteService(String serviceId) throws IOException;
}
