package sep3.db.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {

    private List<String> serviceIdList;

    public Employee(String userName, String password) {
        super(userName, password);
        this.serviceIdList = new ArrayList<>();
    }

    public List<String> getServiceList() {
        return serviceIdList;
    }
}
