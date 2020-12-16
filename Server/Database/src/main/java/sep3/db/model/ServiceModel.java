package sep3.db.model;

import java.util.List;

public interface ServiceModel {
    Service addService(Service service);
    List<Service> getServicesByBusinessId(String businessId);
    List<Service> getServiceByTitle(String title);
    List<Service> getAllServices();
    void deleteService(String serviceId);
}
