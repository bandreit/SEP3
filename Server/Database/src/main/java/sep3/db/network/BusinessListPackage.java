package sep3.db.network;


import sep3.db.model.Business;

import java.util.List;

public class BusinessListPackage extends NetworkPackage {
    private List<Business> businessList;

    public BusinessListPackage(NetworkType type, List<Business> business) {
        super(type);
        this.businessList = business;
    }

    public List<Business> getBusinessList() {
        return businessList;
    }
}
