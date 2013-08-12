package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 05/08/13
 * Time: 07:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBStyle {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("mycollection");

        DBObject document = collection.findOne();
        System.out.println(document);

    }
}
