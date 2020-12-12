package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceModel serviceModel = new ServiceImpl();


    public ServiceServiceImpl() throws IOException {
    }

    @Override
    public void addService(Service service) throws IOException {
        serviceModel.addService(service);
    }

    @Override
    public List<Service> getServicesByBusinessId(String businessId) throws IOException {
        return serviceModel.getServicesByBusinessId(businessId);
    }
}
