package com.tengen;

import com.mongodb.*;
import org.bson.BSON;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hmadrigal on 8/14/14.
 */
public class HomeWork2Item2Test {

    private interface Symbols {
        public final int ASCENDING = 1;
        public final int DESCENDING = -1;

    }

    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient("localhost");
        DB studentsDB = client.getDB("students");
        DBCollection gradesCollection = studentsDB.getCollection("grades");

        DBCursor studentsCursor = gradesCollection
                .find(new BasicDBObject("type","homework"))
                .sort(new BasicDBObject("student_id", Symbols.ASCENDING)
                                .append("score", Symbols.DESCENDING)
                );
        int currentStudentId= Integer.MIN_VALUE;
        int previousStudentId= Integer.MIN_VALUE;
        double currentScore=- Double.MAX_VALUE;
        double previousScore= Double.MAX_VALUE;
        double minScore = Double.MAX_VALUE;
        DBObject studentDocument = null;
        DBObject previousDoc = null;
        List<DBObject> documents = new ArrayList<DBObject>();

        try {
            while (studentsCursor.hasNext()){
                previousDoc = studentDocument;
                studentDocument = studentsCursor.next();
                currentStudentId = (Integer) studentDocument.get("student_id");
                currentScore = (Double) studentDocument.get("score");

                // Makes sure
                if (previousStudentId == Integer.MIN_VALUE){
                    previousStudentId = currentStudentId;
                    previousDoc = studentDocument;
                }

                // Is the same student?
                if (previousStudentId == currentStudentId){
                    minScore = Math.min(minScore,currentScore);
                }else {
                    System.out.println(String.format("***** StudentId: %4s MinScore:%-20f", previousStudentId, minScore));
                    documents.add(previousDoc);
                    minScore = currentScore;
                    previousStudentId = Integer.MIN_VALUE;
                }
                System.out.println(String.format("StudentId: %4s Score:%-20f MinScore:%-20f",currentStudentId,currentScore,minScore));
            }
        }finally {
            studentsCursor.close();
        }
        System.out.println(String.format("***** StudentId: %4s MinScore:%-20f",previousStudentId,minScore));
        documents.add(previousDoc);
        for (DBObject doc : documents)
            gradesCollection.remove(doc);
    }
}
