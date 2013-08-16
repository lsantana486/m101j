package com.tengen_weektwo;

import com.mongodb.*;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 12/08/13
 * Time: 03:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient(new ServerAddress("QFINITIDOMAIN",27017));

        DB database = client.getDB("course");
        DBCollection collection = database.getCollection("insertTest");

        BasicDBObject doc = new BasicDBObject();
        doc.put("userName", "jyemin");
        doc.put("birthDate", new Date(234832423));
        doc.put("programmer", true);
        doc.put("age", 8);
        doc.put("languages", Arrays.asList("Java", "C++"));
        doc.put("address", new BasicDBObject("street", "20 Main st").append("town","Westfield").append("zip","56789"));

        doc.put("_id", new ObjectId());//adding an especific id

        BasicDBObject doc2 = new BasicDBObject().append("x",2);
        System.out.println(doc);

        //collection.insert(doc);  //One Document
        collection.insert(Arrays.<DBObject>asList(doc,doc2)); //a list of documents
        System.out.println(doc2);

    }
}
