package coachingmateanalytics.coachingmate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class databaseTest {
    public static void main(String[] args) {

        String uri = "mongodb+srv://redback:comp90082@cluster0.9yat6.mongodb.net/test";
        // Create a MongoDB Client
        MongoClient mongoClient = MongoClients.create(uri);
        // Create a MongoDB database
        MongoDatabase database = mongoClient.getDatabase("testMark1");
        System.out.println("Test success!");
    }
}