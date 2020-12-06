package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;

@Service
public class MemoryBusinessOwnerService implements BusinessOwnerService {
    private final BusinessOwnerModel businessOwnerModel = new BusinessOwnerImpl();

    public MemoryBusinessOwnerService() throws IOException {
    }

    @Override
    public BusinessOwner getBusinessOwner(String id) throws IOException {
        return businessOwnerModel.getBusinessOwner(id);
    }
}
