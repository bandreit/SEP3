package sep3.db.network;

import sep3.db.model.Business;

import java.util.List;

public class BusinessOwnersBusinesses extends NetworkPackage {

    private List<Business> businessList;
    private String businessOwnerId;

    public BusinessOwnersBusinesses(NetworkType type, List<Business> businessList, String businessOwnerid) {
        super(type);
        this.businessList = businessList;
        this.businessOwnerId = businessOwnerid;

    }

    public List<Business> getBusinessList() {
        return businessList;
    }

    public String getBusinessOwnerId() {
        return businessOwnerId;
    }
}
