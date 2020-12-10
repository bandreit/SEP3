package sep3.db.model;

import java.io.IOException;
import java.util.List;

public interface BusinessListModel {
    List<Business> getAllBusiness() throws IOException;
}
