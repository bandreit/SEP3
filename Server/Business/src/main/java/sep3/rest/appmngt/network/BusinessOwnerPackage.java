package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.BusinessOwner;

public class BusinessOwnerPackage extends NetworkPackage {

    private BusinessOwner businessOwner;

    public BusinessOwnerPackage(NetworkType type, BusinessOwner businessOwner) {
        super(type);
        this.businessOwner = businessOwner;
    }

    public BusinessOwner getBusinessOwner() {
        return businessOwner;
    }
}
