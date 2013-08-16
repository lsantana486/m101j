package com.tengen_weektwo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 12/08/13
 * Time: 04:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindCriteriaTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("findCriteriaTest");
        collection.drop();

        //insert 10 docs with a random value for x
        for (int i=0; i<10; i++){
            collection.insert(new BasicDBObject("x", new Random().nextInt(2)).append("y", new Random().nextInt(100)));
        }

        QueryBuilder builder = QueryBuilder.start("x").is(0).and("y").greaterThan(10).lessThan(70);
        DBObject query = new BasicDBObject("x",0)
                .append("y", new BasicDBObject("$gt",10).append("$lt", 90));

        System.out.println("\nCount:");
        //long count = collection.count(query);
        long count = collection.count(builder.get());
        System.out.println(count);

        System.out.println("\nFind All:");
        //DBCursor cursor = collection.find(query);
        DBCursor cursor = collection.find(builder.get());
        try{
            while(cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        }finally{
            cursor.close();
        }

    }
}
