package com.final_exam;

import com.mongodb.*;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: lsantana
 * Date: 9/18/13
 * Time: 9:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class question_eigth {
    public static void main(String[] args) throws IOException {
        MongoClient c =  new MongoClient(new MongoClientURI("mongodb://10.1.7.63"));
        DB db = c.getDB("test");
        DBCollection animals = db.getCollection("animals");


        BasicDBObject animal = new BasicDBObject("animal", "monkey");
        //final
        animals.insert(animal);
        System.out.println(animal);
        animal.removeField("animal");
        System.out.println(animal);
        animal.append("animal", "cat");
        System.out.println(animal);
        animals.insert(animal);
        System.out.println(animal);
        animal.removeField("animal");
        System.out.println(animal);
        animal.append("animal", "lion");
        System.out.println(animal);
        animals.insert(animal);
        System.out.println(animal);

    }
}
