package sep3.db.network;

public class NetworkPackage {
    private NetworkType type;

    public NetworkPackage(NetworkType type)
    {
        this.type = type;
    }

    public NetworkType getType()
    {
        return type;
    }
}
