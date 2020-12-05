package sep3.rest.appmngt.model;

import com.google.gson.Gson;

import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;

public class BusinessImpl implements BusinessModel {

    private ConnectionHandler connectionManager;
    private final Gson gson;

    public BusinessImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public Business addBusiness(Business business) throws IOException {
        BusinessPackage businessPackage = new BusinessPackage(NetworkType.BUSINESS, business);
        String data = gson.toJson(businessPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        businessPackage = gson.fromJson(receivedData, BusinessPackage.class);
        return businessPackage.getBusiness();
    }
}
