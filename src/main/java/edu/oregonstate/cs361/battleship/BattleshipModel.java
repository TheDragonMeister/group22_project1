package edu.oregonstate.cs361.battleship;

/**
 * Created by River Hendriksen on 1/30/17.
 * Hoo boy did this take a long time to figure out. This is a class that makes that lovely json file that we all want to use you know?
 * it makes a ton of private ships classes (indvidual ships that will make up the battleship model, see ships.java for more info) for the user and the player.
 * It also uses the location class, see that for more info. This object intializes the values for battleship and allows for copying which hopefully will be used
 * to transfer json in the battleship model.
 */

import java.util.*;

public class BattleshipModel {

    //ship names duh
    private ships aircraftCarrier;
    private ships battleship;
    private ships cruiser;
    private ships destroyer;
    private ships submarine;
    private ships computer_aircraftCarrier;
    private ships computer_battleship;
    private ships computer_cruiser;
    private ships computer_destroyer;
    private ships computer_submarine;

    //hit information for the user and computer
    private ArrayList<location> playerHits;
    private ArrayList<location> playerMisses;
    private ArrayList<location> computerHits;
    private ArrayList<location> computerMisses;

    //Intial value for the battleshipmodel object, it calls on the ships object to intialize those values, it's weird trust me.
    public BattleshipModel () {

        //player
        aircraftCarrier = new ships("AircraftCarrier", 5, new location(0,0), new location(0,0));
        battleship = new ships("Battleship", 4, new location(0,0), new location(0,0));
        cruiser = new ships("Cruiser", 3, new location (0,0), new location(0,0));
        destroyer = new ships("Destroyer", 2, new location(0,0), new location(0,0));
        submarine = new ships("Submarine", 2, new location(0,0), new location(0,0));


        //hardcoded locations for the ships
        computer_aircraftCarrier = new ships("Computer_AircraftCarrier", 5, new location(2,2), new location(2,7));
        computer_battleship = new ships("Computer_Battleship", 4, new location(2,8), new location(6,8));
        computer_cruiser = new ships("Computer_Cruiser", 3, new location(4,1), new location(4,4));
        computer_destroyer = new ships("Computer_Destroyer", 2, new location(7,3), new location(7,5));
        computer_submarine = new ships("Computer_Submarine", 2, new location(9,6), new location(9,8));

        //player - again, and computer since this part is not hardcoded
        playerHits = new ArrayList<location>();
        playerMisses = new ArrayList<location>();
        computerHits = new ArrayList<location>();
        computerMisses = new ArrayList<location>();
    }

    //If there are already is a battleship model and you want to convert the inputted json file into the model format, idk if this actually works
    //NOTE: This is for the reqmodel function in main, since i dont use it for new model I left it commented.
    //NOTE: It uses the copy function in the ships file - River

    /*public BattleshipModel(BattleshipModel newship){
        aircraftCarrier= newship.aircraftCarrier;
        battleship = new ships(newship.battleship);
        cruiser = new ships (newship.cruiser);
        destroyer = new ships(newship.destroyer);
        submarine = new ships(newship.submarine);
        computer_aircraftCarrier= new ships(newship.computer_aircraftCarrier);
        computer_battleship = new ships(newship.computer_battleship);
        computer_cruiser = new ships(newship.computer_cruiser);
        computer_destroyer = new ships(newship.computer_destroyer);
        computer_submarine = new ships(newship.computer_submarine);
        playerHits = new ArrayList<location>(newship.playerHits);
        playerMisses = new ArrayList<location>(newship.playerMisses);
        computerHits = new ArrayList<location>(newship.computerHits);
        computerMisses = new ArrayList<location>(newship.computerMisses);
    }*/



    public String userHitsOrMisses(location point){
        String result;

        if(computer_aircraftCarrier.checkIfHit(point,computer_aircraftCarrier))
        {
            result = "you have hit the enemies ship, fire away";
            playerHits.add(point);
        }else if (computer_battleship.checkIfHit(point,computer_battleship))
        {
            result = "you have hit the enemies ship, fire away";
            playerHits.add(point);
        } else if (computer_cruiser.checkIfHit(point,computer_cruiser))
        {
            result = "you have hit the enemies ship, fire away";
            playerHits.add(point);
        } else if (computer_destroyer.checkIfHit(point,computer_destroyer))
        {
            result = "you have hit the enemies ship, fire away";
            playerHits.add(point);
        } else if (computer_submarine.checkIfHit(point,computer_submarine))
        {
            result = "you have hit the enemies ship, fire away";
            playerHits.add(point);
        }
        else{
            result = "You have missed your shot, fire in new location";
            playerMisses.add(point);
        }
        return result;

    }

     /*This function will help the user to place the ships and prints an error if he gives a wrong input
    private String placingShip(String name;int placeHorizontal, int placeVertical, String direction)
    {
        // makes sure starting point isn't out of bounds
        boolean isVertical = direction.equals("vertical");
        if(placeHorizontal > 10 || placeVertical > 10){
            return "Error:Placing out of grid.";
        }
        //Verifys name exists or no

        ships addIt;int length;
        if(aircraftCarrier.checkName(name)) {
            addIt = aircraftCarrier;
            length = addIt.getLength();
            System.out.println("Ship: " + addIt.getName() + "Length: " + addIt.getLength());
        }
        else if(battleship.checkName(name)) {
            addIt = battleship;
            length = addIt.getLength();
            System.out.println("Ship: " + addIt.getName() + "Length: " + addIt.getLength());
        }
        else if (cruiser.checkName(name)) {
            addIt = cruiser;
            length = addIt.getLength();
            System.out.println("Ship: " + addIt.getName() + "Length: " + addIt.getLength());
        }
        else if(destroyer.checkName(name)) {
            addIt = destroyer;
            length = addIt.getLength();
            System.out.println("Ship: " + addIt.getName() + "Length: " + addIt.getLength());
        }
        else if(submarine.checkName(name)){
            addIt = submarine;
            length = addIt.getLength();
            System.out.println("Ship: " + addIt.getName() + "Length: " + addIt.getLength());
        }
        else
            return "Error: No ship of that name";

      //Check for placing the ship

      if((placeHorizontal + length - 1 ) > 10)
        return "Error: Placement out of grid";
    } else{
        if((placeVertical + length - 1 ) > 10)
            return "Error: Placement out of grid";
    }
    int noHorizontal;
    int noVertical;
    Point start = new Point(placeHorizontal, placeVertical);
    Point end = new Point();
        if(isVertical){
        noHorizontal = placeHorizontal + length - 1;
        noVertical = placeVertical;
        end.setPoint(noHorizontal, noVertical);
    } else {
        noHorizontal = placeHorizontal;
        noVertical = placeVertical + length - 1;
        end.setPoint(noHorizontal, noVertical);
    }


    ships toCheck = new ships(name, length, start, end);
    boolean overlaps = checkShipOverlap(toCheck);
        if(overlaps){
        return "Error:One Ship placed over the other";
    }
        addIt.setStart(placeHorizontal, placeVertical);
        addIt.setEnd(noHorizontal, noVertical);

        return "Placing Successfull: Placed " + name + " at " + placeHorizontal + ", " + placeVertical;
}
*/
    public String computerHitsOrMisses(location point){
        String result;

        if(aircraftCarrier.checkIfHit(point,computer_aircraftCarrier))
        {
            result = "you have hit the enemies ship, fire away";
            computerHits.add(point);
        }else if (battleship.checkIfHit(point,computer_battleship))
        {
            result = "you have hit the enemies ship, fire away";
            computerHits.add(point);
        } else if (cruiser.checkIfHit(point,computer_cruiser))
        {
            result = "you have hit the enemies ship, fire away";
            computerHits.add(point);
        } else if (destroyer.checkIfHit(point,computer_destroyer))
        {
            result = "you have hit the enemies ship, fire away";
            computerHits.add(point);
        } else if (submarine.checkIfHit(point,computer_submarine))
        {
            result = "you have hit the enemies ship, fire away";
            computerHits.add(point);
        }
        else{
            result = "You have missed your shot, fire in new location";
            computerHits.add(point);
        }
        return result;

    }


     public String placingShip(String idNo, int placeHorizontal, int placeVertical, String orientation) {
         return idNo;
    }
}
