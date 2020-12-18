package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.Business;

import java.util.List;

/**
 * The type Business list package.
 */
public class BusinessListPackage extends NetworkPackage {
    private List<Business> businessList;

    /**
     * Instantiates a new Business list package.
     *
     * @param type     the type
     * @param business the business
     */
    public BusinessListPackage(NetworkType type, List<Business> business) {
        super(type);
        this.businessList = business;
    }

    /**
     * Gets business list.
     *
     * @return the business list
     */
    public List<Business> getBusinessList() {
        return businessList;
    }
}
