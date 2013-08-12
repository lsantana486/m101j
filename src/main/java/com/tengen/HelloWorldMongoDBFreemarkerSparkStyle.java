package com.tengen;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 05/08/13
 * Time: 09:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBFreemarkerSparkStyle {
    public static void main(String[] args) throws UnknownHostException {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerSparkStyle.class,"/");

        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("course");
        final DBCollection collection = database.getCollection("mycollection");


        Spark.get(new Route("/h") {

            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    DBObject document = collection.findOne();


                    helloTemplate.process(document, writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                return writer;
            }
        });
    }
}
