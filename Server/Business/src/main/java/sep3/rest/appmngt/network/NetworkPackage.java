package sep3.rest.appmngt.network;

public class NetworkPackage {
    private final NetworkType type;

    public NetworkPackage(NetworkType type)
    {
        this.type = type;
    }

    public NetworkType getType()
    {
        return type;
    }
}
