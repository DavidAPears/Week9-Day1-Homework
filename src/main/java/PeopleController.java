import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class PeopleController {


    public static void main(String[] args) {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");

        ArrayList<People> peoples = new ArrayList<>();

        People people1 = new People("Alex", "Smith");
        People people2 = new People("Sam", "Jones");
        People people3 = new People("Charlie", "Sanderson");
        People people4 = new People("Finley", "Thompson");

        peoples.add(people1);
        peoples.add(people2);
        peoples.add(people3);
        peoples.add(people4);


//      BELOW RETURNS A FULL LIST OF NAMES (on /people)

        get("/people", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("peoples", peoples);
            model.put("template", "peoples.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);



//      BELOW RETURNS A RANDOM NAME (on /random_name)


        get ("/random_name", (req, res) -> {
            ArrayList<People> names = new ArrayList<>();

            Collections.shuffle(peoples);
            names.add(peoples.get(0));
            return names.get(0).getFirstName();
        });



    }
}

