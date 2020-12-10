package sep3.rest.appmngt.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessOwner extends User {
    private List<Business> businessList;
    public BusinessOwner(String userName, String password) {
        super(userName, password);
        this.businessList = new ArrayList<>();
    }

    public BusinessOwner(String id, String userName, String password, String email, String city, String role, String firstName, String lastName, String phone) {
        super(id, userName, password, email, city, role, firstName, lastName, phone);
    }
}
