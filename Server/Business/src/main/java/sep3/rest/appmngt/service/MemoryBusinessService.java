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
    public void addBusiness(Business business) throws IOException {
        businessModel.addBusiness(business);
    }
}
