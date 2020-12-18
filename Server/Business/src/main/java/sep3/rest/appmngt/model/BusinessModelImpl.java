package sep3.rest.appmngt.model;

import com.google.gson.Gson;

import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Business model.
 */
public class BusinessModelImpl implements BusinessModel {

    private final ConnectionHandler connectionManager;
    private final Gson gson;

    /**
     * Instantiates a new Business model.
     *
     * @throws IOException the io exception
     */
    public BusinessModelImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    /**
     * Adding services and  exchanging business data with database
     *
     * @param business Business
     * @return
     */
    @Override
    public Business addBusiness(Business business) throws IOException {
        BusinessPackage businessPackage = new BusinessPackage(NetworkType.BUSINESS, business);
        String data = gson.toJson(businessPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        businessPackage = gson.fromJson(receivedData, BusinessPackage.class);
        return business;
    }

    /**
     * Setting nulls to new arrayList
     *
     * @param business
     */
    private Business SetNullToEmptyArrays(Business business) {
        if (business.getLocations() == null) {
            business.setLocations(new ArrayList<>());
        }

        if (business.getEmployees() == null) {
            business.setEmployees(new ArrayList<>());
        }
        if (business.getServices() == null) {
            business.setServices(new ArrayList<>());
        }
        return business;
    }

    /**
     * Adding employee and  sending data to database
     *
     * @param serviceId String
     * @param businessId String
     * @param employeeId List of Strings
     */
    @Override
    public void addEmployee(List<String> employeeId, String businessId, String serviceId) throws IOException {
        EmployeePackage employeePackage = new EmployeePackage(NetworkType.EMPLOYEE, employeeId, businessId, serviceId);
        String data = gson.toJson(employeePackage);
        connectionManager.sendToServer(data);
    }

    /**
     * Removing employee and sending data to database
     *
     * @param businessId String
     * @param employeeId String
     */
    @Override
    public void removeEmployee(String employeeId, String businessId) throws IOException {
        EmployeePackage employeePackage = new EmployeePackage(NetworkType.REMOVEEMPLOYEE, employeeId, businessId);
        String data = gson.toJson(employeePackage);
        connectionManager.sendToServer(data);
    }

    /**
     * Getting all businesses and exchanging list of businesses data with database
     *
     * @return list of businesses
     */
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

    /**
     * Getting owned businesses
     *
     * @return list of businesses
     */
    @Override
    public List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException {
        List<Business> listOfbusiness = getAllBusiness();
        listOfbusiness.removeIf(business -> !(business.getBusinessOwnerID().equals(businessOwnerId)));
        return listOfbusiness;
    }
    /**
     * Getting  businesses by id
     * @param id String
     * @return list of businesses that matches id
     */
    @Override
    public Business getBusinessById(String id) throws IOException {
        for (int i = 0; i < getAllBusiness().size(); i++) {
            if (getAllBusiness().get(i).getId().equals(id)) {
                return getAllBusiness().get(i);
            }
        }
        return null;
    }

    /**
     * Editing business  and sending business to database
     * @param business Business
     */
    @Override
    public void editBusiness(Business business) throws IOException {
        BusinessPackage businessPackage = new BusinessPackage(NetworkType.EDITBUSINESS, business);
        String data = gson.toJson(businessPackage);
        connectionManager.sendToServer(data);
    }

}
