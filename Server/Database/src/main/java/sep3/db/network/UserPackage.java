package sep3.db.network;

import sep3.db.model.User;

/**
 * The type User package.
 */
public class UserPackage extends NetworkPackage {

    private User user;

    /**
     * Instantiates a new User package.
     *
     * @param type the type
     * @param user the user
     */
    public UserPackage(NetworkType type, User user) {
        super(type);
        this.user = user;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser()
    {
        return user;
    }

    public String toString()
    {
        return getType() + ": " + user;
    }
}
