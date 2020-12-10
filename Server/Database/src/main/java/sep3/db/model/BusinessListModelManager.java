package sep3.db.model;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusinessListModelManager implements BusinessListModel {
    private final MongoCollection<Document> businessCollection;
    private final Gson gson;

    public BusinessListModelManager(MongoDatabase database) {
        businessCollection = database.getCollection("business");
        gson = new Gson();
    }

    @Override
    public List<Business> getAllBusiness() throws IOException {
        List<Business> listOfBusiness = new ArrayList<>();
        MongoCursor<Document> cursor = businessCollection.find().iterator();

        if (businessCollection.find().first() != null) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Business fromDocumentToObject = gson.fromJson(document.toJson(), Business.class);
                listOfBusiness.add(fromDocumentToObject);
            }
            return listOfBusiness;
        }
        return listOfBusiness;
    }

}

