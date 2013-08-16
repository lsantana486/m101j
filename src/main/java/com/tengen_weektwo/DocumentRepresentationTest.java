package com.tengen_weektwo;

import com.mongodb.BasicDBObject;

import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 12/08/13
 * Time: 02:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class DocumentRepresentationTest {
    public static void main(String[] args) {
        BasicDBObject doc = new BasicDBObject();
        doc.put("userName", "jyemin");
        doc.put("birthDate", new Date(234832423));
        doc.put("programmer", true);
        doc.put("age", 8);
        doc.put("languages", Arrays.asList("Java","C++"));
        doc.put("address", new BasicDBObject("street", "20 Main st").append("town","Westfield").append("zip","56789"));

    }
}
