package sep3.db.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BusinessOwner extends User {
    private List<Business> businessList;

    public BusinessOwner(String userName, String password) {
        super(userName, password);
        this.businessList = new ArrayList<>();
    }
    public BusinessOwner(String id, String userName, String password, String email, String city, String role, String firstName, String lastName, String phone) {
        super(id, userName, password, email, city, role, firstName, lastName, phone);
        this.businessList=new ArrayList<>();
    }
    public List<Business> getBusinessList() {
        return businessList;
    }
}
