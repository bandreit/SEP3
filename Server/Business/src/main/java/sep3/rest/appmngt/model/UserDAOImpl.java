package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.UserPackage;
import sep3.rest.appmngt.service.UserService;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    private ConnectionHandler connectionManager;
    private Gson gson;

    public UserDAOImpl() throws IOException {
        this.gson = new Gson();
    }

    @Override
    public User ValidateUser(String userName, String password) throws IOException {
        {
            ConnectionManager connectionManager = ConnectionManager.getInstance();

            UserPackage userPackage = new UserPackage(NetworkType.USER, new User(userName, password));
            String data = gson.toJson(userPackage);
            connectionManager.sendToServer(data);

            String receivedData = connectionManager.readFromServer();
            userPackage = gson.fromJson(receivedData, UserPackage.class);

            return userPackage.getUser();
        }
    }
}
