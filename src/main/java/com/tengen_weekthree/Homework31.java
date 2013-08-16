package com.tengen_weekthree;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 16/08/13
 * Time: 04:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Homework31 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("students");
        DBCollection collection = database.getCollection("grades");

        QueryBuilder builder = QueryBuilder.start("type").is("homework");

        DBCursor cursor = collection.find(builder.get()).sort(new BasicDBObject("student_id",1).append("score",-1));
    }
}
