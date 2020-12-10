package sep3.rest.appmngt.service;


import sep3.rest.appmngt.model.Service;

import java.io.IOException;

public interface ServiceService {
    void addService(Service service) throws IOException;
}
