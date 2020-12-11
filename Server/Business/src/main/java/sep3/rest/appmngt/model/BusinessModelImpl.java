package sep3.rest.appmngt.model;

import com.google.gson.Gson;

import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;
import java.util.List;

public class BusinessModelImpl implements BusinessModel {

    private final ConnectionHandler connectionManager;
    private final Gson gson;

    public BusinessModelImpl() throws IOException {
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

    @Override
    public Service addService(Service service, String id) throws IOException {
        ServicePackage servicePackage = new ServicePackage(NetworkType.SERVICE, service, id);
        String data = gson.toJson(servicePackage);
        connectionManager.sendToServer(data);
        String receiveData = connectionManager.readFromServer();
        servicePackage = gson.fromJson(receiveData, ServicePackage.class);
        return servicePackage.getService();
    }

    @Override
    public Employee addEmployee(Employee employee, String businessId) throws IOException {
        EmployeePackage employeePackage = new EmployeePackage(NetworkType.EMPLOYEE, employee, businessId);
        String data = gson.toJson(employeePackage);
        connectionManager.sendToServer(data);
        String recieveData = connectionManager.readFromServer();
        employeePackage = gson.fromJson(recieveData, EmployeePackage.class);
        return employeePackage.getEmployee();
    }

    @Override
    public List<Business> getAllBusiness() throws IOException {
        //wtf is in here?
//        BusinessListPackage businessListPackage = new BusinessListPackage(NetworkType.BUSINESSLIST,new ArrayList<>());
//        String data = gson.toJson(businessListPackage);
//        connectionManager.sendToServer(data);
//        String receivedData = connectionManager.readFromServer();
//        businessListPackage = gson.fromJson(receivedData, BusinessListPackage.class);
//        return businessListPackage.getBusinessList();
        return null;
    }
}
