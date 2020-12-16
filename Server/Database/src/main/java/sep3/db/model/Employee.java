package sep3.db.model;

import com.google.gson.annotations.Expose;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {

    private ObjectId userID;
    @Expose(serialize = true, deserialize = false)
    private List<String> serviceIdList;

    public Employee(String userName, String password) {
        super(userName, password);
        this.serviceIdList = new ArrayList<>();
    }

    public List<String> getServiceList() {
        return serviceIdList;
    }

    public void setServiceIdList(List<String> serviceIdList) {
        this.serviceIdList = serviceIdList;
    }
}

