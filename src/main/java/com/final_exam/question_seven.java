package com.final_exam;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: lsantana
 * Date: 9/18/13
 * Time: 8:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class question_seven {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("10.1.7.63",27017));

        DB database = client.getDB("final");
        DBCollection images = database.getCollection("images");
        DBCollection albums = database.getCollection("albums");

        DBCursor cur_imgs = images.find(new BasicDBObject(),new BasicDBObject("_id",true));
        DBObject al = null;
        DBObject obj = null;
        while(cur_imgs.hasNext()) {
            obj = cur_imgs.next();
            al = albums.findOne(new BasicDBObject("images",obj.get("_id")));
            if (al==null){
                images.remove(new BasicDBObject("_id",obj.get("_id")));
                //System.out.println(obj.get("_id"));
            }
            //System.out.println(al);
        }
        cur_imgs.close();
    }
}
/*

        try{
            //Integer stID = 0;
            String stID = "0";
            ObjectId docID = null;

            while(cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(tcnt);
                if ( !(cur.get("student_id").toString().equals(stID))){
                    // collection.remove(new BasicDBObject("_id",docID));
                    //System.out.println("match");
                    //System.out.println(stID);
                    //System.out.println(docID);
                    System.out.println("not match");
                    System.out.println(stID);
                    System.out.println(cnt);
                    collection.remove(new BasicDBObject("_id",docID));

//                }else{
//                    System.out.println("not match");
//                    System.out.println(stID);
//                    collection.remove(new BasicDBObject("_id",docID));
                }
                if (cnt==tcnt) {
                    collection.remove(new BasicDBObject("_id",docID));
                }
                //System.out.println(cur.get("student_id"));
                stID = cur.get("student_id").toString();
                docID = (ObjectId) cur.get("_id");
                cnt++;

            }
        }finally{
            cursor.close();
        }
    }
*/


