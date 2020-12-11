package sep3.rest.appmngt.model;

import com.google.gson.Gson;

import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;
import java.util.ArrayList;
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

        Business receivedBusiness = businessPackage.getBusiness();
        if (receivedBusiness.getLocations() == null) {
            receivedBusiness.setLocation(new ArrayList<>());
        }

        if (receivedBusiness.getEmployees() == null) {
            receivedBusiness.setEmployees(new ArrayList<>());
        }
        if (receivedBusiness.getServices() == null) {
            receivedBusiness.setServices(new ArrayList<>());
        }

        return receivedBusiness;
    }

    @Override
    public void addEmployee(String employeeId, String businessId) throws IOException {
        EmployeePackage employeePackage = new EmployeePackage(NetworkType.EMPLOYEE, employeeId, businessId);
        String data = gson.toJson(employeePackage);
        connectionManager.sendToServer(data);
    }

    @Override
    public void removeEmployee(String employeeId, String businessId) throws IOException {
        EmployeePackage employeePackage = new EmployeePackage(NetworkType.REMOVEEMPLOYEE, employeeId, businessId);
        String data = gson.toJson(employeePackage);
        connectionManager.sendToServer(data);
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
