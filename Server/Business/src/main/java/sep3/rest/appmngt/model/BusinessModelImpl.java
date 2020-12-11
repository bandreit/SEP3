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

        Business receivedBusiness = SetNullToEmptyArrays(businessPackage.getBusiness());

        return receivedBusiness;
    }

    private Business SetNullToEmptyArrays(Business business) {
        if (business.getLocations() == null) {
            business.setLocation(new ArrayList<>());
        }

        if (business.getEmployees() == null) {
            business.setEmployees(new ArrayList<>());
        }
        if (business.getServices() == null) {
            business.setServices(new ArrayList<>());
        }
        return business;
    }

    @Override
    public void addEmployee(String employeeId, String businessId) throws IOException {
        EmployeePackage employeePackage = new EmployeePackage(NetworkType.EMPLOYEE, employeeId, businessId);
        String data = gson.toJson(employeePackage);
        connectionManager.sendToServer(data);
    }

    @Override
    public List<Business> getAllBusiness() throws IOException {
        List<Business> listOfBuinesses = new ArrayList<>();
        BusinessListPackage businessListPackage = new BusinessListPackage(NetworkType.BUSINESSLIST, listOfBuinesses);
        String data = gson.toJson(businessListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        businessListPackage = gson.fromJson(receivedData, BusinessListPackage.class);
        listOfBuinesses = businessListPackage.getBusinessList();
        for (Business business : listOfBuinesses) {
            business = SetNullToEmptyArrays(business);
        }
        return businessListPackage.getBusinessList();
    }

    @Override
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException {
     List<Business> listOfbusiness = getAllBusiness();
     listOfbusiness.removeIf(business -> !(business.get_businessOwnerID().equals(businessOwnerId)));
     return listOfbusiness;
    }

}
