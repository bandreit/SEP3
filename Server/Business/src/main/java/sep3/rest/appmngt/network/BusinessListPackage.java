package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Business;

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
