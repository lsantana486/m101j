package com.tengen_weektwo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 12/08/13
 * Time: 04:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindTest {

    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("findTest");
        collection.drop();

        //insert 10 docs with a random value for x
        for (int i=0; i<10; i++){
            collection.insert(new BasicDBObject("x", new Random().nextInt(100)));
        }

        System.out.println("Find one:");
        DBObject one = collection.findOne();
        System.out.println(one);

        System.out.println("\nFind All:");
        DBCursor cursor = collection.find();
        try{
            while(cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        }finally{
                cursor.close();
        }


        System.out.println("\nCount:");
        long count = collection.count();
        System.out.println(count);

    }
}
