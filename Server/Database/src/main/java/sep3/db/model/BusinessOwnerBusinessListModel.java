package sep3.db.model;

import java.io.IOException;
import java.util.List;

public interface BusinessOwnerBusinessListModel {
    List<Business> getOwnedBusinesses(String businessOwnerId) throws IOException;
}
