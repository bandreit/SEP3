package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.BusinessPackage;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.ServiceListPackage;
import sep3.rest.appmngt.network.ServicePackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Service> getServicesByBusinessId(String businessId) throws IOException {
        List<Service> serviceListById = new ArrayList<>();
        ServiceListPackage serviceListByIdPackage = new ServiceListPackage(NetworkType.SERVICELISTBYBUSINESSID,serviceListById, businessId);
        String data = gson.toJson(serviceListByIdPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        serviceListByIdPackage = gson.fromJson(receivedData, ServiceListPackage.class);
        return serviceListByIdPackage.getServiceList();
    }

    @Override
    public List<Service> getServiceByTitle(String title) throws IOException {
        List<Service> serviceListByTitle = new ArrayList<>();
        ServiceListPackage serviceListByTitlePackage = new ServiceListPackage(NetworkType.SERVICELISTBYTITLE,serviceListByTitle, title);
        String data = gson.toJson(serviceListByTitlePackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        serviceListByTitlePackage = gson.fromJson(receivedData, ServiceListPackage.class);
        return serviceListByTitlePackage.getServiceList();
    }

    @Override
    public List<Service> getAllServices() throws IOException {
        List<Service> serviceList = new ArrayList<>();
        ServiceListPackage serviceListPackage = new ServiceListPackage(NetworkType.SERVICELIST,serviceList);
        String data = gson.toJson(serviceListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        serviceListPackage = gson.fromJson(receivedData, ServiceListPackage.class);
        return serviceListPackage.getServiceList();
    }
}
