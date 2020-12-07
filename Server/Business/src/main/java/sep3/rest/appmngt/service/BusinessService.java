package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.Business;

import java.io.IOException;

public interface BusinessService {
    void addBusiness(Business business,String id) throws IOException;
}
