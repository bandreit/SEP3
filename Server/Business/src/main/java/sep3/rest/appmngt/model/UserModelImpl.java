package sep3.rest.appmngt.model;

import com.google.gson.Gson;
import sep3.rest.appmngt.mediator.ConnectionHandler;
import sep3.rest.appmngt.mediator.ConnectionManager;
import sep3.rest.appmngt.network.CreateUserPackage;
import sep3.rest.appmngt.network.EmployeeListPackage;
import sep3.rest.appmngt.network.NetworkType;
import sep3.rest.appmngt.network.UserPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserModelImpl implements UserModel {
    private final ConnectionHandler connectionManager;
    private final Gson gson;

    public UserModelImpl() throws IOException {
        this.gson = new Gson();
        this.connectionManager = ConnectionManager.getInstance();
    }

    @Override
    public User ValidateUser(String userName) throws IOException {
        UserPackage userPackage = new UserPackage(NetworkType.USER, new User(userName, ""));
        String data = gson.toJson(userPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        userPackage = gson.fromJson(receivedData, UserPackage.class);
        return userPackage.getUser();
    }

    @Override
    public User RegisterUser(User user) throws IOException {
        CreateUserPackage userPackage = new CreateUserPackage(NetworkType.CREATE_USER, user);
        String data = gson.toJson(userPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        userPackage = gson.fromJson(receivedData, CreateUserPackage.class);
        return userPackage.getUser();
    }

    @Override
    public List<Employee> getAllEmployees() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        EmployeeListPackage employeeListPackage = new EmployeeListPackage(NetworkType.EMPLOYEELIST, employeeList);
        String data = gson.toJson(employeeListPackage);
        connectionManager.sendToServer(data);
        String receivedData = connectionManager.readFromServer();
        employeeListPackage = gson.fromJson(receivedData, EmployeeListPackage.class);
        return employeeListPackage.getEmployeeList();
    }
}
