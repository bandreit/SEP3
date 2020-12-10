package sep3.rest.appmngt.model;

import com.google.gson.Gson;

import org.bson.Document;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.BusinessListPackage;
import sep3.rest.appmngt.network.BusinessPackage;
import sep3.rest.appmngt.network.NetworkType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusinessListImpl implements BusinessListModel {
    private ConnectionHandler connectionManager;
    private final Gson gson;

    public BusinessListImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }


    @Override
    public List<Business> getAllBusiness() throws IOException {
        //wtf is in here?
        BusinessListPackage businessListPackage = new BusinessListPackage(NetworkType.BUSINESSLIST,new ArrayList<>());
        String data = gson.toJson(businessListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        businessListPackage = gson.fromJson(receivedData, BusinessListPackage.class);
        return businessListPackage.getBusinessList();
    }
}
