package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.network.NetworkPackage;
import sep3.rest.appmngt.network.NetworkType;

public class BusinessPackage extends NetworkPackage {

    private Business business;
    private String businessOwnerId;

    public BusinessPackage(NetworkType type, Business business, String businessOwnerId) {
        super(type);
        this.business = business;
        this.businessOwnerId = businessOwnerId;
    }

    public Business getBusiness() {
        return business;
    }

    public String getBusinessOwnerId() {
        return businessOwnerId;
    }
}
