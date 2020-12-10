package sep3.db.model;

import java.util.List;
public class BusinessList {
    List<Business> businessList;

    public BusinessList(List<Business> businessList) {
        this.businessList = businessList;
    }

    public List<Business> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<Business> businessList) {
        this.businessList = businessList;
    }
}
