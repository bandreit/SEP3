package sep3.db.mediator;

import com.google.gson.Gson;
import sep3.db.model.BusinessOwner;
import sep3.db.model.Model;
import sep3.db.model.User;
import sep3.db.network.BusinessOwnerPackage;
import sep3.db.network.NetworkPackage;
import sep3.db.network.NetworkType;
import sep3.db.network.UserPackage;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Model modelManager;
    private Gson gson;


    public ClientHandler(Socket socket, Model modelManager) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        this.modelManager = modelManager;
        this.gson = new Gson();
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
                    case USER:
                        UserPackage incomingUserPackageNumber = gson.fromJson(message, UserPackage.class);
                        User user = incomingUserPackageNumber.getUser();

                        User returnedUser = modelManager.ValidateUser(user.getUserName(), user.getPassword());
                        UserPackage outgoingUserPackage = new UserPackage(NetworkType.USER, returnedUser);

                        String response = gson.toJson(outgoingUserPackage);
                        sendData(response);

                        break;
                    case BUSINESSOWNER:
                        BusinessOwnerPackage incomingBusinessOwnerPackageNumber = gson.fromJson(message, BusinessOwnerPackage.class);
                        BusinessOwner businessOwner = incomingBusinessOwnerPackageNumber.getBusinessOwner();

                        BusinessOwner returnedBusinessOwner = modelManager.getBusinessOwner(businessOwner.getId());
                        BusinessOwnerPackage outgoingBusinessOwnerPackage = new BusinessOwnerPackage(NetworkType.BUSINESSOWNER, returnedBusinessOwner);

                        String businessResponse = gson.toJson(outgoingBusinessOwnerPackage);
                        sendData(businessResponse);
                    case ERROR:
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
}
