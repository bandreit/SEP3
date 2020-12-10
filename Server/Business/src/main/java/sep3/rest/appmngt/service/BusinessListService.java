package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Business;

import java.io.IOException;
import java.util.List;

public interface BusinessListService {
    List<Business> getAllBusiness() throws IOException;
}
