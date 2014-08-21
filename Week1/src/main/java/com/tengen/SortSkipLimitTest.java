package com.tengen;


import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by hmadrigal on 8/14/14.
 */
public class SortSkipLimitTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("SortSkipLimitTest");
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
        QueryBuilder builder = QueryBuilder.start();
        DBObject query  = builder.get();

        System.out.println("Find all:");
        DBCursor cursor = collection
                .find(query)
                .sort(new BasicDBObject("start.y",-1))
                .skip(2)
                .limit(3);
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
