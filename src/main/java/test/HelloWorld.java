package test;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        staticFiles.location("/public");

        get("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", "Velocity World");
            model.put("person", new Person("Foobar"));
            model.put("message", "TEST");

            // The wm files are located under the resources directory
            return new ModelAndView(model, "hello.vm");
        }, new VelocityTemplateEngine());


    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}