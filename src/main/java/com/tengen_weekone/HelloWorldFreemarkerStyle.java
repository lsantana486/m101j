package com.tengen_weekone;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrador
 * Date: 05/08/13
 * Time: 09:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class,"/");

        try {
            Template helloTemplate =configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name","Freemarker");
            helloMap.put("text","new text");

            helloTemplate.process(helloMap,writer);
            System.out.println(writer);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
