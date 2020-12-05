package sep3.db.network;

import sep3.db.model.Business;
import sep3.db.model.BusinessOwner;

public class BusinessPackage extends NetworkPackage {

    private Business business;

    public BusinessPackage(NetworkType type, Business business) {
        super(type);
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }
}
