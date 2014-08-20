package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by hmadrigal on 8/13/14.
 */
public class FindTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("findTest");
        collection.drop();


        for (int i = 0; i < 10; i ++){
            collection.insert(new BasicDBObject("x", new Random().nextInt(100)));
        }

        System.out.println("Find one:");
        DBObject one = collection.findOne();
        System.out.println(one);

        System.out.println("Find all:");
        DBCursor cursor = null;
        cursor = collection.find();
        try {
            while(cursor.hasNext())
            {
                DBObject doc =  cursor.next();
                System.out.println(doc);
            }
        }finally {
            cursor.close();
        }

        System.out.println("Count:");
        long count = collection.count();
        System.out.println(count);
    }
}
