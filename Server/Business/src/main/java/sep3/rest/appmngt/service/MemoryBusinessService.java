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
}
