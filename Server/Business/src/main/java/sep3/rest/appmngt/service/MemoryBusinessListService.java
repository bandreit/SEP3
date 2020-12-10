package sep3.rest.appmngt.service;

import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.*;

import java.io.IOException;
import java.util.List;

@Service
public class MemoryBusinessListService implements BusinessListService {
    private final BusinessListModel businessOwnerModel = new BusinessListImpl();

    public MemoryBusinessListService() throws IOException {
    }


    @Override
    public List<Business> getAllBusiness() throws IOException {
        return businessOwnerModel.getAllBusiness();
    }
}
