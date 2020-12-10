package sep3.db.model;

import java.util.List;

public class BusinessOwnerBusinessList {
    List<Business> ownedBusinessesList;

    public BusinessOwnerBusinessList(List<Business> businessList) {
        this.ownedBusinessesList = businessList;
    }

    public List<Business> getBusinessList() {
        return ownedBusinessesList;
    }

    public void setBusinessList(List<Business> businessList) {
        this.ownedBusinessesList = businessList;
    }
}
