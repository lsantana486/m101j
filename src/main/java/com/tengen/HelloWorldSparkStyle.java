package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 05/08/13
 * Time: 08:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get(new Route("/h") {

            @Override
            public Object handle(Request request, Response response) {
                return "Hello World From Spark";
            }
        });
    }

}
