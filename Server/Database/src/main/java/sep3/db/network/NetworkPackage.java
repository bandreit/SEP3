package sep3.db.network;

/**
 * The type Network package.
 */
public class NetworkPackage {
    private NetworkType type;

    /**
     * Instantiates a new Network package.
     *
     * @param type the type
     */
    public NetworkPackage(NetworkType type)
    {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public NetworkType getType()
    {
        return type;
    }
}
