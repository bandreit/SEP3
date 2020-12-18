package sep3.db.network;

/**
 * The type Query package.
 */
public class QueryPackage extends NetworkPackage{
    private final String queryString;
    private Object carryObject;

    /**
     * Instantiates a new Query package.
     *
     * @param type        the type
     * @param queryString the query string
     * @param object      the object
     */
    public QueryPackage(NetworkType type, String queryString, Object object) {
        super(type);
        this.queryString = queryString;
        this.carryObject = object;
    }

    /**
     * Gets query.
     *
     * @return the query
     */
    public String getQuery()
    {
        return queryString;
    }

    /**
     * Gets carry object.
     *
     * @return the carry object
     */
    public Object getCarryObject() {
        return carryObject;
    }

    /**
     * Sends back type with query in string and the object
     *
     * @return type+query+object
     */
    public String toString()
    {
        return getType() + ": " + queryString + " - " + carryObject;
    }
}
