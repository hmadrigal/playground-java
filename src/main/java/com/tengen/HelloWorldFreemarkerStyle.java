package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by herberthm on 8/11/2014.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        // Gets the configuration of the template engine.
        Configuration  configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        try {

            // Gets an instance of the template
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();

            // Object with values for the template engine
            Map<String,Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name","Freemarker");

            helloTemplate.process(helloMap, writer);

            System.out.println(writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
