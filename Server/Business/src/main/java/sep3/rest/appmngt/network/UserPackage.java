package sep3.rest.appmngt.network;

import sep3.rest.appmngt.model.User;

public class UserPackage extends NetworkPackage {

    private final User user;

    public UserPackage(NetworkType type, User user) {
        super(type);
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }

    public String toString()
    {
        return getType() + ": " + user;
    }
}
