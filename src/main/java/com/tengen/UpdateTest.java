package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by hmadrigal on 8/14/14.
 */
public class UpdateTest {

    public static void main(String[] args) throws UnknownHostException {
        DBCollection collection = createCollection();
        List<String> names = Arrays.asList("alice","bobby", "cathy","david","ethan");
        for (String name :  names){
            collection.insert(new BasicDBObject("_id",name));
        }
        System.out.println("Update: Replace the document");
        // Update: Replace the document
        collection.update(new BasicDBObject("_id","alice"),new BasicDBObject("age",34));
        printCollection(collection);

        // Update: Updates/inserts a new field
        System.out.println("Update: Updates/inserts a new field");
        collection.update(new BasicDBObject("_id","bobby"), new BasicDBObject("$set", new BasicDBObject("title","jr")));
        printCollection(collection);

        // Update: Updates multiple instances
        System.out.println("Update: Updates multiple instances");
        collection.update(new BasicDBObject(), new BasicDBObject("$set", new BasicDBObject("title","dr")),true,true);
        printCollection(collection);

        // Remove:
        System.out.println("Remove:");
        collection.remove(new BasicDBObject("_id","alice"));
        printCollection(collection);

    }

    private static void printCollection(DBCollection collection) {
        DBCursor cursor = collection.find();
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

    private static DBCollection createCollection() throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("UpdateTest");
        collection.drop();
        collection = database.getCollection("UpdateTest");
        return collection;
    }
}
