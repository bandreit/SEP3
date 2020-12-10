package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.*;

import java.io.IOException;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceModel serviceModel = new ServiceImpl();


    public ServiceServiceImpl() throws IOException {
    }

    @Override
    public void addService(Service service) throws IOException {
        serviceModel.addService(service);
    }
}
