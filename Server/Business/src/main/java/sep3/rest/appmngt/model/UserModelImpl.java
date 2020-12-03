package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.UserPackage;

import java.io.IOException;

public class UserModelImpl implements UserModel {
    private ConnectionHandler connectionManager;
    private final Gson gson;

    public UserModelImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public User ValidateUser(String userName, String password) throws IOException {
        {
            UserPackage userPackage = new UserPackage(NetworkType.USER, new User(userName, password));
            String data = gson.toJson(userPackage);
            connectionManager.sendToServer(data);
            String receivedData = connectionManager.readFromServer();
            userPackage = gson.fromJson(receivedData, UserPackage.class);
            System.out.println(userPackage.getUser().getId());
            return userPackage.getUser();
        }
    }
}
