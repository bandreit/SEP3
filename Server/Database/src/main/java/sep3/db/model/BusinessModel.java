package sep3.db.model;

import org.bson.Document;

import java.io.IOException;
import java.util.List;

public interface BusinessModel {
    Business addBusiness(Business business,String id);
}
