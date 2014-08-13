package com.tengen;

import com.mongodb.BasicDBObject;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by herberthm on 8/13/2014.
 */
public class DocumentRepresentationTest {
    public static void main(String[] args) {
        BasicDBObject doc = new BasicDBObject();
        doc.put("userName", "jyesmin");
        doc.put("birthDate",new Date(234832423));
        doc.put("programmer",true);
        doc.put("age",8);
        doc.put("languages", Arrays.asList("Java","C++"));
        doc.put("address",new BasicDBObject()
            .append("street","20 Main")
            .append("town","Westfield")
            .append("zip","56789"));
    }
}
