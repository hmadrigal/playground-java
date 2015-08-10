package com.tengen;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.mongodb.gridfs.GridFSInputFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by herberthm on 8/20/2014.
 */
public class GridFSTest {
    public static void main(String[] args) throws IOException {
        MongoClient client = new MongoClient("localhost",27017);
        DB db = client.getDB("course");
        FileInputStream inputStream = null;

        // Creates the GridFS collection into the given database.
        GridFS videos = new GridFS(db,"videos");

        // Prepares an input stream for the GridFS entry
        try {
            inputStream = new FileInputStream("video.mp4");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't open file");
            System.exit(1);
        }
        // Creates an entry for the GridFS table
        GridFSInputFile video = videos.createFile(inputStream, "video.mp4");

        // Attach some metadata to the GridFS entry
        BasicDBObject metadata = new BasicDBObject("description","Jennifer Singing");
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("Singing");
        tags.add("Opera");
        metadata.append("tags", tags);
        video.setMetaData(metadata);

        // saves the GridFS entry
        video.save();

        System.out.println("Object ID in Files Collection: " + video.get("_id"));
        System.out.println("Saved the file to MongoDB");

        // Preparing for reading the GridFS entry
        System.out.println("Now lets read it back out");
        // fetch the GridFS entry
        GridFSDBFile gridFile = videos.findOne(new BasicDBObject("filename","video.mp4"));
        // Copies the GridFS stream to a target stream
        FileOutputStream outputStream = new FileOutputStream("video_copy.mp4");
        gridFile.writeTo(outputStream);

        System.out.println("Write the file back out");
    }
}
