package sep3.rest.appmngt.model;

import java.io.IOException;
import java.util.List;

public interface ServiceModel {
    Service addService(Service service) throws IOException;
    List<Service> getServicesByBusinessId(String businessId) throws IOException;
    List<Service> getServiceByTitle(String title) throws IOException;
    List<Service> getAllServices() throws IOException;
    void deleteService(String serviceId) throws IOException;
}
