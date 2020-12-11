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
        byte[] responseAsBytes = response.getBytes();
        outputStream.write(responseAsBytes, 0, responseAsBytes.length);
    }

    @Override
    public void run() {
        while (true) {
            try {
                //input bytes
                byte[] lenbytes = new byte[1024];
                int read = inputStream.read(lenbytes, 0, lenbytes.length);
                String message = new String(lenbytes, 0, read);


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
                    case BUSINESSLIST :
                        List<Business> businessList = businessModel.getAllBusiness();

                        BusinessListPackage outgoingBusinessListPackage = new BusinessListPackage(NetworkType.BUSINESS, businessList);

                        String businessListResponse = gson.toJson(outgoingBusinessListPackage);
                        sendData(businessListResponse);

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
