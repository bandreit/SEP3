package sep3.db.mediator;

import com.google.gson.Gson;
import sep3.db.model.Model;
import sep3.db.model.User;
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

    @Override
    public void run() {
        while (true) {
            try {
                //input bytes
                byte[] lenbytes = new byte[1024];
                int read = inputStream.read(lenbytes,0,lenbytes.length);
                String message = new String(lenbytes,0,read);
                //output bytes


                //incoming data
                System.out.println("Client>" + message);
                NetworkPackage incoming = gson.fromJson(message, NetworkPackage.class);

                switch (incoming.getType()) {
                    case USER:
                        UserPackage incomingUserPackageNumber = gson.fromJson(message, UserPackage.class);
                        User user = incomingUserPackageNumber.getUser();
                        User returnedUser = modelManager.ValidateUser(user.getUserName(), user.getPassword());
                        UserPackage outgoingUserPackage = new UserPackage(NetworkType.USER, returnedUser);
                        String response = gson.toJson(outgoingUserPackage);
                        byte[] responseAsBytes = response.getBytes();
                        outputStream.write(responseAsBytes, 0, responseAsBytes.length);
                        break;
                    case ERROR:
                        response = "Error stuff";
                        responseAsBytes = response.getBytes();
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
