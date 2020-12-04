package sep3.db.network;

public class QueryPackage extends NetworkPackage{
    private final String queryString;

    public QueryPackage(NetworkType type, String queryString) {
        super(type);
        this.queryString = queryString;
    }

    public String getQuery()
    {
        return queryString;
    }

    public String toString()
    {
        return getType() + ": " + queryString;
    }
}
