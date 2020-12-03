package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.BusinessOwnerPackage;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.UserPackage;

import java.io.IOException;

public class BusinessOwnerImpl implements BusinessOwnerModel {

    private ConnectionHandler connectionManager;
    private final Gson gson;

    public BusinessOwnerImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public BusinessOwner getBusinessOwner(String id) throws IOException {
        {
            BusinessOwnerPackage businessOwnerPackage = new BusinessOwnerPackage(NetworkType.BUSINESSOWNER, new BusinessOwner("asdsa","xxx"));
            String data = gson.toJson(businessOwnerPackage);
            System.out.println(data + "here");
            connectionManager.sendToServer(data);
            String receivedData = connectionManager.readFromServer();
            businessOwnerPackage = gson.fromJson(receivedData, BusinessOwnerPackage.class);
            System.out.println(businessOwnerPackage.getBusinessOwner());
            return businessOwnerPackage.getBusinessOwner();
        }
    }
}
