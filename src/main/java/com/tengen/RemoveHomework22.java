package com.tengen;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 12/08/13
 * Time: 05:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveHomework22 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("students");
        DBCollection collection = database.getCollection("grades");

        QueryBuilder builder = QueryBuilder.start("type").is("homework");

        DBCursor cursor = collection.find(builder.get()).sort(new BasicDBObject("student_id",1).append("score",-1));
        try{
            //Integer stID = 0;
            String stID = "0";
            ObjectId docID = null;

            while(cursor.hasNext()) {
                DBObject cur = cursor.next();
                if ( cur.get("student_id").toString().equals(stID)){
                   // collection.remove(new BasicDBObject("_id",docID));
                    System.out.println("match");
                    //System.out.println(stID);
                    //System.out.println(docID);
                }else{
                    System.out.println("not match");
                    System.out.println(stID);
                    collection.remove(new BasicDBObject("_id",docID));
                }
                //System.out.println(cur.get("student_id"));
                stID = cur.get("student_id").toString();
                docID = (ObjectId) cur.get("_id");

            }
        }finally{
            cursor.close();
        }
    }
}
