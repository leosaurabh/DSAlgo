import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss030277 on 5/29/15.
 */
public class TestMongo {

    public static void main(String args[]) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("test");
//        db.getCollection("testdata").deleteOne(new Document("1", "2"));
//        db.getCollection("testdata").deleteMany(new Document("c", "d"));
//        db.getCollection("testdata").deleteOne(new Document("c", "d"));
//        db.getCollection("testdata").deleteOne(new Document("a", "b"));
//        insert(db);
        print(db.getCollection("testdata").find());
        System.out.println();
        print(db.getCollection("testdata").find(new Document("1", "2")));
        System.out.println();
        print(db.getCollection("testdata").find(eq("1", "2")));
        System.out.println();
        print(db.getCollection("testdata").find(new Document("X.X1", "X1")));
        System.out.println();
        print(db.getCollection("testdata").find(new Document("X.X2", "X2")));
    }

    public static void insert(MongoDatabase db) {
        db.getCollection("testdata").insertOne(new Document("a","b"));

//        List<Document> documents = new ArrayList<Document>();
//        documents.add(new Document("a", "b"));
//        documents.add(new Document("c", "d"));
//        db.getCollection("testdata").insertMany(documents);
//
//        db.getCollection("testdata").insertOne(new Document("X",
//                new Document().append("X1", "X1").append("X2", "X2")));
    }

    public static void print(FindIterable<Document> documents) {
        documents.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }
}
