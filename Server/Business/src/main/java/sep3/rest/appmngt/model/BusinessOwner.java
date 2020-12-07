package sep3.rest.appmngt.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessOwner extends User {
    private List<Business> businessList;
    public BusinessOwner(String userName, String password) {
        super(userName, password);
        this.businessList = new ArrayList<>();
    }

}
