package sep3.db.network;

import sep3.db.model.Business;
import sep3.db.model.BusinessOwner;

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
