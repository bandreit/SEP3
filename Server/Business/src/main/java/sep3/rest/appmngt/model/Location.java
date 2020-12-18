package sep3.rest.appmngt.model;

import java.util.List;

/**
 * The type Location.
 */
public class Location {
    private String streetNumber;
    private String streetName;

    /**
     * Instantiates a new Location.
     *
     * @param streetNumber the street number
     * @param streetName   the street name
     */
    public Location(String streetNumber, String streetName) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
    }

    /**
     * Gets street number.
     *
     * @return the street number
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * Sets street number.
     *
     * @param streetNumber the street number
     */
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Gets street name.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
