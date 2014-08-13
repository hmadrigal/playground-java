package com.tengen;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by herberthm on 8/11/2014.
 */
public class HelloWorldMongoDBSparkFreemarketStyle {
    public static void main(String[] args) throws UnknownHostException {

        // Gets the configuration of the template engine.
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        MongoClient client = new MongoClient("localhost",27017);
        DB database = client.getDB("course");
        final DBCollection collection = database.getCollection("hello");

        Spark.get(new Route("/") {
            @Override
            public Object handle(
                    final Request request,
                    final Response response) {

                StringWriter writer = new StringWriter();
                try {

                    // Gets an instance of the template
                    Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");

                    // Object with values for the template engine
                    Map<String,Object> fruitsMap = new HashMap<String, Object>();
                    fruitsMap.put("fruits", Arrays.asList("apple","orange","banana","peach"));

                    fruitPickerTemplate.process(fruitsMap, writer);

                } catch (IOException e) {
                    halt(500);
                    e.printStackTrace();
                } catch (TemplateException e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });

        Spark.post(new Route("/favorite_fruit") {
            @Override
            public Object handle(Request request, Response response) {
                final String fruit = request.queryParams("fruit");
                if (fruit == null) {
                    return "why don't you pick one?";
                }else{
                    return "Your favorite fruit is " + fruit;
                }
            }
        });
    }
}
