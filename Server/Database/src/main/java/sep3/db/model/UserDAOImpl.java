package sep3.db.model;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class UserDAOImpl implements UserDAO {

    private final MongoCollection<Document> collection;

    public UserDAOImpl(MongoDatabase database) {
        collection = database.getCollection("users");
    }

    @Override
    public User ValidateUser(String userName, String password) {
        {
//            FindIterable<Document> iterable = collection.find();
//            MongoCursor<Document> cursor = iterable.iterator();
//            System.out.println("Student list with a cursor: ");
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }

            if (collection.find(eq("userName", userName)).first() != null) {
                Document user = collection.find(eq("userName", userName)).first();
                System.out.println(user.toJson());
            }

            return null;
        }
    }
}
