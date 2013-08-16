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

        DB database = client.getDB("school");
        DBCollection collection = database.getCollection("students");

        //QueryBuilder builder = QueryBuilder.start("type").is("homework");

        DBCursor cursor = collection.find().sort(new BasicDBObject("_id",1));

        while(cursor.hasNext()) {
            DBObject cur = cursor.next();
            System.out.println(cur.get("scores"));
        }

    }
}
