package sep3.db.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BusinessOwner extends User {

    public BusinessOwner(String userName, String password) {
        super(userName, password);
    }

}
