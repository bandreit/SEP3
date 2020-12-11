package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.network.NetworkPackage;
import sep3.rest.appmngt.network.NetworkType;

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
