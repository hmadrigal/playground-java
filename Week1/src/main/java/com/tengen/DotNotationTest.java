package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by hmadrigal on 8/14/14.
 */
public class DotNotationTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("DotNotationTest");
        collection.drop();


        for (int i = 0; i < 10; i ++){
            collection.insert(
                    new BasicDBObject("_id",i)
                    .append("start", new BasicDBObject()
                            .append("x", new Random().nextInt(90) + 10)
                            .append("y", new Random().nextInt(90) + 10)
                    )
                    .append("end", new BasicDBObject()
                            .append("x", new Random().nextInt(90) + 10)
                            .append("y", new Random().nextInt(90) + 10)
                    )
            );
        }
        // Creating filter expression by using QueryBuilder
        QueryBuilder builder = QueryBuilder.start("start.x").greaterThan(50);
        DBObject query  = builder.get();

        System.out.println("Find all:");
        DBCursor cursor = null;
        cursor = collection.find(query, new BasicDBObject("start.y",true).append("_id",false));
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
