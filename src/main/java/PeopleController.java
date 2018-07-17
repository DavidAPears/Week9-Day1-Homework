import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;

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
        People people5 = new People("Ronnie", "Waters");
        People people6 = new People("Terry", "Fredrickson");


        peoples.add(people1);
        peoples.add(people2);
        peoples.add(people3);
        peoples.add(people4);
        peoples.add(people5);
        peoples.add(people6);




//  BELOW RETURNS A FULL LIST OF NAMES (on /people):

        get("/people", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("peoples", peoples);
            model.put("template", "peoples.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);



//  BELOW RETURNS A RANDOM NAME (on /one):

        get ("/one", (req, res) -> {
            ArrayList<People> names = new ArrayList<>();

            Collections.shuffle(peoples);
            names.add(peoples.get(0));
            return names.get(0).getName();
        });


////  BELOW RETURNS A PAIR OF RANDOM NAMES(on /two):

        get ("/two", (req, res) -> {
            ArrayList<People> twoNames = new ArrayList<>();

            Collections.shuffle(peoples);
            twoNames.add(peoples.get(0));
            twoNames.add(peoples.get(1));
            return twoNames.get(0).getName() + " " + twoNames.get(1).getName() ;

        });

////  BELOW RETURNS THREE RANDOM NAMES(on /three):

        get ("/three", (req, res) -> {
            ArrayList<People> threeNames = new ArrayList<>();

            Collections.shuffle(peoples);
            threeNames.add(peoples.get(0));
            threeNames.add(peoples.get(1));
            threeNames.add(peoples.get(2));
            return threeNames.get(0).getName() + " " + threeNames.get(1).getName() + " " + threeNames.get(2).getName();
        });

////  BELOW RETURNS FOUR RANDOM NAMES (on /four):

        get ("/four", (req, res) -> {
            ArrayList<People> fourNames = new ArrayList<>();

            Collections.shuffle(peoples);
            fourNames.add(peoples.get(0));
            fourNames.add(peoples.get(1));
            fourNames.add(peoples.get(2));
            fourNames.add(peoples.get(3));
            return fourNames.get(0).getName() + " " + fourNames.get(1).getName() + " " + fourNames.get(2).getName() + " " + fourNames.get(3).getName();
        });

    }
}

