package com.tengen_weekthree;

import com.mongodb.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 16/08/13
 * Time: 04:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Homework31 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("200.26.166.241",27017));

        DB database = client.getDB("school");
        DBCollection collection = database.getCollection("students");

        //QueryBuilder builder = QueryBuilder.start("type").is("homework");

        DBCursor cursor = collection.find().sort(new BasicDBObject("_id",1));
        BasicDBObject obj;

        ArrayList scores;
        int i;
        int ix;
        Double scoreA;
        Double scoreB;
        while(cursor.hasNext()) {
            DBObject cur = cursor.next();

            scores = (ArrayList) cur.get("scores");
            //System.out.println(scores);
            i = 0;
            ix = 0;
            scoreA = Double.valueOf(100);
            scoreB = Double.valueOf(0);
            while (i < scores.size()){
                obj= (BasicDBObject) scores.get(i);


                if (obj.containsValue("homework")){
                    scoreB =  (Double) obj.get("score");

                    if (scoreB < scoreA) {
                        scoreA = scoreB;
                        ix = i;
                    }

                }
                i++;
            }
            System.out.println(scores);
            System.out.println(scoreA);
            System.out.println(ix);
            //scores.remove(ix);
            //System.out.println(scores);
            //collection.update(new BasicDBObject("_id", cur.get("_id")), new BasicDBObject("scores",scores));
        }

    }
}
