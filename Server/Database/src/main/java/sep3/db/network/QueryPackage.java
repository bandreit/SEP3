package sep3.db.network;

public class QueryPackage extends NetworkPackage{
    private final String queryString;
    private Object carryObject;

    public QueryPackage(NetworkType type, String queryString, Object object) {
        super(type);
        this.queryString = queryString;
        this.carryObject = object;
    }

    public String getQuery()
    {
        return queryString;
    }

    public Object getCarryObject() {
        return carryObject;
    }


    public String toString()
    {
        return getType() + ": " + queryString + " - " + carryObject;
    }
}
