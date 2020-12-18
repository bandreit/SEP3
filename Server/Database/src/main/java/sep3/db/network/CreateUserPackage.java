package sep3.db.network;


import sep3.db.model.User;

/**
 * The type Create user package.
 */
public class CreateUserPackage extends NetworkPackage {

    private final User user;

    /**
     * Instantiates a new Create user package.
     *
     * @param type the type
     * @param user the user
     */
    public CreateUserPackage(NetworkType type, User user) {
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
