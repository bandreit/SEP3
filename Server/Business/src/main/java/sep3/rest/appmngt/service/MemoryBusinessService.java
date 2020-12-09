package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;

@Service
public class MemoryBusinessService implements BusinessService {
    private final BusinessModel businessModel = new BusinessImpl();

    public MemoryBusinessService() throws IOException {
    }

    @Override
    public Business addBusiness(Business business,String id) throws IOException {
        return businessModel.addBusiness(business,id);
    }

    @Override
    public sep3.rest.appmngt.model.Service addService(sep3.rest.appmngt.model.Service service, String id) throws IOException {
        return businessModel.addService(service,id);
    }

    @Override
    public Employee addEmployee(Employee employee, String businessId) throws IOException {
        return businessModel.addEmployee(employee, businessId);
    }
}
