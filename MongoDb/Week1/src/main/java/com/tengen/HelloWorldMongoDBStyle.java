package com.tengen;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by herberthm on 8/11/2014.
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient("localhost",27017);
        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("hello");
        DBObject document = collection.findOne();
        System.out.println(document);
    }
}
