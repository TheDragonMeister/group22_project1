package edu.oregonstate.cs361.battleship;

import spark.Request;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {

        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");


        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }

    //This function should return a new model- fuck this description no
    //battleship model creates the structure that is going to be used and all fuckin new model does
    // is create a new battleship and put it into json. that is so dumb.
    static String newModel() {
        BattleshipModel doggo = new BattleshipModel();
        //builds that beautiful json
        Gson gson = new Gson();
        //the .tojson json into a string which is the return type of this function
        String model = new String(gson.toJson(doggo));
        return model;
        //return null;
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object. -possibly the worst description i have ever seen
    //poorly worded and the first reference of battleship model with no explanation of what it actually does
    //battleshipmodel is a class that creates the structure that will be used to manipulate the json file. it is annoying that it isn't mentioned anywhere in instructions
    private static BattleshipModel getModelFromReq(Request req){

        return null;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        return null;
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {
        return null;
    }

}