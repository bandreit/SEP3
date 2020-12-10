package sep3.rest.appmngt.network;


import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.BusinessOwner;

public class BusinessWithBusinessOwnerIdPackage extends NetworkPackage {
    private String  businessOwnerId;
    private Business business;

    public BusinessWithBusinessOwnerIdPackage(NetworkType type, Business business, String  businessOwnerId) {
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
