package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.BusinessOwner;

import java.io.IOException;

public interface BusinessOwnerService {
    BusinessOwner getBusinessOwner(String id) throws IOException;
}
