package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.BusinessPackage;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.ServicePackage;

import java.io.IOException;

public class ServiceImpl implements ServiceModel {
    private ConnectionHandler connectionManager;
    private final Gson gson;

    public ServiceImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public Service addService(Service service) throws IOException {
        ServicePackage servicePackage = new ServicePackage(NetworkType.SERVICE, service);
        String data = gson.toJson(servicePackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        servicePackage = gson.fromJson(receivedData, ServicePackage.class);
        return servicePackage.getService();
    }
}
