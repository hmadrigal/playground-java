package com.tengen;

import freemarker.template.Configuration;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by herberthm on 8/11/2014.
 */
public class SparkFormHandlingStyle {
    public static void main(String[] args) {

        // Gets the configuration of the template engine.
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {

                return null;
            }
        });
    }
}
