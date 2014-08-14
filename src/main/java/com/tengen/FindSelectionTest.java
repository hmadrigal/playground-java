package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by hmadrigal on 8/13/14.
 */
public class FindSelectionTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("FindSelectionTest");
        collection.drop();


        for (int i = 0; i < 10; i ++){
            collection.insert(new BasicDBObject()
                .append("x", new Random().nextInt(2))
                .append("y", new Random().nextInt(100))
                .append("z", new Random().nextInt(1000))
            );
        }

        // Creating filter expression by using documents (JSON objects)
        DBObject query  = new BasicDBObject()
                .append("x",0)
                .append("y", new BasicDBObject("$gt",10).append("$lt",90));

        // Creating filter expression by using QueryBuilder
        QueryBuilder builder = QueryBuilder.start("x").is(0).and("y").greaterThan(10).and("y").lessThan(90);
        query = builder.get();


        // Specifying the selected fields in the results
        DBObject selection = new BasicDBObject()
                .append("x", false)
                ;

        System.out.println("Find all:");
        DBCursor cursor = null;
        cursor = collection.find(query,selection);
        try {
            while(cursor.hasNext())
            {
                DBObject doc =  cursor.next();
                System.out.println(doc);
            }
        }finally {
            cursor.close();
        }
    }
}
