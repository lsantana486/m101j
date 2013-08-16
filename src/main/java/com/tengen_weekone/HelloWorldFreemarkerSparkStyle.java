package com.tengen_weekone;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 05/08/13
 * Time: 09:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreemarkerSparkStyle {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerSparkStyle.class,"/");

        Spark.get(new Route("/h") {

            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate =configuration.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name","Freemarker");
                    helloMap.put("text","new text");

                    helloTemplate.process(helloMap,writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                return writer;
            }
        });
    }
}
