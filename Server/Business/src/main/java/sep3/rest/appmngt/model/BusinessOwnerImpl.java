package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.BusinessOwnerPackage;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.QueryPackage;
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
            QueryPackage queryPackage = new QueryPackage(NetworkType.QUERY, "get_business_owner_by_id", id);
            String data = gson.toJson(queryPackage);
            connectionManager.sendToServer(data);
            String receivedData = connectionManager.readFromServer();
            BusinessOwnerPackage businessOwnerPackage = gson.fromJson(receivedData, BusinessOwnerPackage.class);
            return businessOwnerPackage.getBusinessOwner();
        }
    }
}
