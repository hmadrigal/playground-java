package com.tengen;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;

/**
 * Created by herberthm on 8/13/2014.
 */
public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDatabase = client.getDB("course");
        DBCollection collection = courseDatabase.getCollection("insertTest");

        // Makes sure that the collection is empty
        collection.drop();

        // Simple insert
        DBObject doc1 = new BasicDBObject();
        doc1.put("x", 1);
        System.out.println("OBJ1|BEFORE: %s" + doc1);
        collection.insert(doc1);
        System.out.println("OBJ1|AFTER: %s" + doc1);

        // Creating an ID before its insertion
        DBObject doc2 = new BasicDBObject();
        doc2.put("_id", new ObjectId());
        doc2.put("x", 2);
        System.out.println("OBJ2|BEFORE: %s" + doc2);
        collection.insert(doc2);
        System.out.println("OBJ2|AFTER: %s" + doc2);

        // Inserting multiple docs


        // Trying to insert a duplicated document... throws an exception

    }
}
