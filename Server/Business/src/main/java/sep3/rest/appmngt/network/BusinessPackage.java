package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.network.NetworkPackage;
import sep3.rest.appmngt.network.NetworkType;

/**
 * The type Business package.
 */
public class BusinessPackage extends NetworkPackage {

    private Business business;

    /**
     * Instantiates a new Business package.
     *
     * @param type     the type
     * @param business the business
     */
    public BusinessPackage(NetworkType type, Business business) {
        super(type);
        this.business = business;
    }

    /**
     * Gets business.
     *
     * @return the business
     */
    public Business getBusiness() {
        return business;
    }
}
