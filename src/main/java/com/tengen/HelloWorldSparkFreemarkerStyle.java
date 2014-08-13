package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by herberthm on 8/11/2014.
 */
public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {

        // Gets the configuration of the template engine.
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(
                    final Request request,
                    final Response response) {

                StringWriter writer = new StringWriter();
                try {

                    // Gets an instance of the template
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    // Object with values for the template engine
                    Map<String,Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name","Freemarker");

                    helloTemplate.process(helloMap, writer);

                    System.out.println(writer);
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
    }
}
