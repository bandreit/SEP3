package sep3.db.network;

import sep3.db.model.BusinessOwner;
import sep3.db.model.User;

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
