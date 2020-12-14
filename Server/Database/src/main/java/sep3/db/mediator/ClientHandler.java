package sep3.db.mediator;

import com.google.gson.Gson;
import sep3.db.model.*;
import sep3.db.network.*;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private UserModel modelManager;
    private Gson gson;
    private BusinessModel businessModel;
    private ServiceModel serviceModel;


    public ClientHandler(Socket socket, UserModel modelManager, BusinessModel businessModel, ServiceModel serviceModel) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        this.modelManager = modelManager;
        this.gson = new Gson();
        this.businessModel = businessModel;
        this.serviceModel = serviceModel;
    }


    private void sendData(String response) throws IOException {
        byte[] toSendBytes = response.getBytes();
        int toSendLen = toSendBytes.length;
        byte[] toSendLenBytes = new byte[4];
        toSendLenBytes[0] = (byte) (toSendLen & 0xff);
        toSendLenBytes[1] = (byte) ((toSendLen >> 8) & 0xff);
        toSendLenBytes[2] = (byte) ((toSendLen >> 16) & 0xff);
        toSendLenBytes[3] = (byte) ((toSendLen >> 24) & 0xff);
        outputStream.write(toSendLenBytes);
        outputStream.write(toSendBytes);
    }

    @Override
    public void run() {
        while (true) {
            try {
                //input bytes
                byte[] lenBytes = new byte[4];
                inputStream.read(lenBytes, 0, 4);
                int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                        ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
                byte[] receivedBytes = new byte[len];
                inputStream.read(receivedBytes, 0, len);

                String message = new String(receivedBytes, 0, len);

                //incoming data
                System.out.println("Tier2>" + message);
                NetworkPackage incoming = gson.fromJson(message, NetworkPackage.class);

                switch (incoming.getType()) {
                    case QUERY:
                        handleQueryMethods(message);
                        break;
                    case USER:
                        UserPackage incomingUserPackageNumber = gson.fromJson(message, UserPackage.class);
                        User user = incomingUserPackageNumber.getUser();

                        User returnedUser = modelManager.ValidateUser(user.getUserName(), user.getPassword());
                        UserPackage outgoingUserPackage = new UserPackage(NetworkType.USER, returnedUser);

                        String response = gson.toJson(outgoingUserPackage);
                        sendData(response);
                        break;

                    case CREATE_USER:
                        CreateUserPackage incomingCreateUserPackageNumber = gson.fromJson(message, CreateUserPackage.class);
                        User userToCreate = incomingCreateUserPackageNumber.getUser();

                        User toReturnCreatedUser = modelManager.RegisterUser(userToCreate);
                        UserPackage outgoingCreatedUserPackage = new UserPackage(NetworkType.USER, toReturnCreatedUser);

                        String createdUserResponse = gson.toJson(outgoingCreatedUserPackage);
                        sendData(createdUserResponse);
                        break;

                    case BUSINESS:
                        BusinessPackage incomingBusinessPackageNumber = gson.fromJson(message, BusinessPackage.class);
                        Business business = incomingBusinessPackageNumber.getBusiness();

                        Business addedBusiness = businessModel.addBusiness(business);
                        BusinessPackage outgoingBusinessPackage = new BusinessPackage(NetworkType.BUSINESS, addedBusiness);

                        String businessResponse = gson.toJson(outgoingBusinessPackage);
                        sendData(businessResponse);
                        break;

                    case SERVICE:
                        ServicePackage incomingServicePackageNumber = gson.fromJson(message, ServicePackage.class);
                        Service service = incomingServicePackageNumber.getService();

                        Service addedService = serviceModel.addService(service);
                        ServicePackage outgoingServicePackage = new ServicePackage(NetworkType.SERVICE, addedService);

                        String serviceResponse = gson.toJson(outgoingServicePackage);
                        sendData(serviceResponse);
                        break;

                    case EMPLOYEE:
                        EmployeePackage incomingEmployeePackageNumber = gson.fromJson(message, EmployeePackage.class);
                        String employeeId = incomingEmployeePackageNumber.getEmployeeId();
                        String businessIdEmpl = incomingEmployeePackageNumber.getBusinessId();

                        businessModel.addEmployee(employeeId, businessIdEmpl);
                        break;
                    case BUSINESSLIST:
                        List<Business> businessList = businessModel.getAllBusiness();

                        BusinessListPackage outgoingBusinessListPackage = new BusinessListPackage(NetworkType.BUSINESS, businessList);

                        String businessListResponse = gson.toJson(outgoingBusinessListPackage);
                        sendData(businessListResponse);

                        break;
                    case REMOVEEMPLOYEE:
                        EmployeePackage incomingRemoveEmployeePackageNumber = gson.fromJson(message, EmployeePackage.class);
                        String removedEmployeeId = incomingRemoveEmployeePackageNumber.getEmployeeId();
                        String businessId = incomingRemoveEmployeePackageNumber.getBusinessId();

                        businessModel.removeEmployee(removedEmployeeId, businessId);
                        break;
                    case EMPLOYEELIST:
                        List<Employee> employeeList = modelManager.getAllEmployees();

                        EmployeeListPackage outgoingUserListPackage = new EmployeeListPackage(NetworkType.EMPLOYEELIST, employeeList);

                        String userListResponse = gson.toJson(outgoingUserListPackage);
                        sendData(userListResponse);
                        break;

                    case SERVICELISTBYBUSINESSID:
                        ServiceListPackage incomingServiceListByIdPackage = gson.fromJson(message, ServiceListPackage.class);
                        String businessIdService = incomingServiceListByIdPackage.getFilter();

                        List<Service> serviceListById = serviceModel.getServicesByBusinessId(businessIdService);
                        ServiceListPackage outgoingServiceListByIdPackage = new ServiceListPackage(NetworkType.SERVICELIST, serviceListById, businessIdService);

                        String serviceListByIdResponse = gson.toJson(outgoingServiceListByIdPackage);
                        sendData(serviceListByIdResponse);
                        break;

                    case SERVICELISTBYTITLE:
                        ServiceListPackage incomingServiceListByTitlePackage = gson.fromJson(message, ServiceListPackage.class);
                        String title = incomingServiceListByTitlePackage.getFilter();

                        List<Service> serviceListByTitle = serviceModel.getServiceByTitle(title);
                        ServiceListPackage outgoingServiceListByTitlePackage = new ServiceListPackage(NetworkType.SERVICELIST, serviceListByTitle, title);

                        String serviceListByTitleResponse = gson.toJson(outgoingServiceListByTitlePackage);
                        sendData(serviceListByTitleResponse);
                        break;

                    case SERVICELIST:
                        List<Service> serviceList = serviceModel.getAllServices();

                        ServiceListPackage outgoingServiceListPackage = new ServiceListPackage(NetworkType.SERVICELIST, serviceList);

                        String serviceListResponse = gson.toJson(outgoingServiceListPackage);
                        sendData(serviceListResponse);
                        break;

                    case ERROR:
                    default:
                        sendData("ERROR");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Client disconnected");
                e.printStackTrace();
                break;
            }
        }
    }

    private void handleQueryMethods(String message) throws IOException {
        QueryPackage incomingQueryPackage = gson.fromJson(message, QueryPackage.class);
        String query = incomingQueryPackage.getQuery();
        Object carryObject = incomingQueryPackage.getCarryObject();
        switch (query) {
            case "get_business_owner_by_id":
//                String idToGetBusinessOwnerBy = carryObject.toString();
//                BusinessOwner returnedBusinessOwner = businessOwnerModel.getBusinessOwner(idToGetBusinessOwnerBy);
//                BusinessOwnerPackage outgoingBusinessOwnerPackage = new BusinessOwnerPackage(NetworkType.BUSINESSOWNER, returnedBusinessOwner);
//
//                String businessOwnerResponse = gson.toJson(outgoingBusinessOwnerPackage);
//                sendData(businessOwnerResponse);
                break;

            default:
                sendData("ERROR");
        }
    }
}
