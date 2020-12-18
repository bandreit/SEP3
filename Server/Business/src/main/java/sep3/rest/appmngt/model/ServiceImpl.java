package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Service.
 */
public class ServiceImpl implements ServiceModel {
    private ConnectionHandler connectionManager;
    private final Gson gson;

    /**
     * Instantiates a new Service.
     *
     * @throws IOException the io exception
     */
    public ServiceImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }
    /**
     * Adding services  by exchanging service with database
     *
     * @param service String
     * @return added service
     */
    @Override
    public Service addService(Service service) throws IOException {
        ServicePackage servicePackage = new ServicePackage(NetworkType.SERVICE, service);
        String data = gson.toJson(servicePackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        servicePackage = gson.fromJson(receivedData, ServicePackage.class);
        return servicePackage.getService();
    }
    /**
     * Getting services by id exchanging service list with database
     *
     * @param businessId String
     * @return service list
     */
    @Override
    public List<Service> getServicesByBusinessId(String businessId) throws IOException {
        List<Service> serviceListById = new ArrayList<>();
        ServiceListPackage serviceListByIdPackage = new ServiceListPackage(NetworkType.SERVICELISTBYBUSINESSID, serviceListById, businessId);
        String data = gson.toJson(serviceListByIdPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        serviceListByIdPackage = gson.fromJson(receivedData, ServiceListPackage.class);
        return serviceListByIdPackage.getServiceList();
    }
    /**
     * Getting services  by title exchanging service list with database
     *
     * @param title String
     * @return service list
     */
    @Override
    public List<Service> getServiceByTitle(String title) throws IOException {
        List<Service> serviceListByTitle = new ArrayList<>();
        ServiceListPackage serviceListByTitlePackage = new ServiceListPackage(NetworkType.SERVICELISTBYTITLE, serviceListByTitle, title);
        String data = gson.toJson(serviceListByTitlePackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        serviceListByTitlePackage = gson.fromJson(receivedData, ServiceListPackage.class);
        return serviceListByTitlePackage.getServiceList();
    }
    /**
     * Getting services  exchanging service list with database
     *
     * @return service list
     */
    @Override
    public List<Service> getAllServices() throws IOException {
        List<Service> serviceList = new ArrayList<>();
        ServiceListPackage serviceListPackage = new ServiceListPackage(NetworkType.SERVICELIST, serviceList);
        String data = gson.toJson(serviceListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        serviceListPackage = gson.fromJson(receivedData, ServiceListPackage.class);
        return serviceListPackage.getServiceList();
    }
    /**
     * Deleting services by service id
     */
    @Override
    public void deleteService(String serviceId) throws IOException {
        QueryPackage queryPackage = new QueryPackage(NetworkType.QUERY, "delete_service", serviceId);
        String data = gson.toJson(queryPackage);
        connectionManager.sendToServer(data);
    }
}
