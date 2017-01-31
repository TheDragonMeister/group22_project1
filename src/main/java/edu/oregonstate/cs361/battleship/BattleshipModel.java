package edu.oregonstate.cs361.battleship;

/**
 * Created by River Hendriksen on 1/30/17.
 */

import java.util.*;

public class BattleshipModel {

    //ship names duh
    private ships aircraftcarrier;
    private ships battleship;
    private ships cruiser;
    private ships destroyer;
    private ships submarine;
    private ships computer_aircraftercarrier;
    private ships computer_battleship;
    private ships computer_cruiser;
    private ships computer_destroyer;
    private ships computer_submarine;

    //hit information for the user and computer
    private ArrayList<int[]> playerHits;
    private ArrayList<int[]> playerMisses;
    private ArrayList<int[]> ComputerHits;
    private ArrayList<int[]> ComputerMisses;

    //Intial value for the battleshipmodel object, it calls on the ships object to intialize those values, it's weird trust me.
    public BattleshipModel () {
        aircraftcarrier = new ships("aircraftCarrier", 5, new int[] {0,0}, new int[] {0,0});
        battleship = new ships("battleship", 4, new int[] {0,0}, new int[] {0,0});
        cruiser = new ships("cruiser", 3, new int[] {0,0}, new int[] {0,0});
        destroyer = new ships("destroyer", 2, new int[] {0,0}, new int[] {0,0});
        submarine = new ships("submarine", 2, new int[] {0,0}, new int[] {0,0});
        computer_aircraftercarrier = new ships("Computer_aircraftCarrier", 5, new int[] {0,0}, new int[] {0,0});
        computer_battleship = new ships("Computer_battleship", 4, new int[] {0,0}, new int[] {0,0});
        computer_cruiser = new ships("Computer_cruiser", 3, new int[] {0,0}, new int[] {0,0});
        computer_destroyer = new ships("Computer_destroyer", 2, new int[] {0,0}, new int[] {0,0});
        computer_submarine = new ships("Computer_submarine", 2, new int[] {0,0}, new int[] {0,0});
    }

    //If there are already is a battleship model and you want to convert the inputted json file into the model format, idk if this actually works
    public BattleshipModel(BattleshipModel newship){
        aircraftcarrier= newship.aircraftcarrier;
        battleship = new ships(newship.battleship);
        cruiser = new ships (newship.cruiser);
        destroyer = new ships(newship.destroyer);
        submarine = new ships(newship.submarine);
        computer_aircraftercarrier= new ships(newship.computer_aircraftercarrier);
        computer_battleship = new ships(newship.computer_battleship);
        computer_cruiser = new ships(newship.computer_cruiser);
        computer_destroyer = new ships(newship.computer_destroyer);
        computer_submarine = new ships(newship.computer_submarine);
        playerHits = newship.playerHits;
        playerMisses = newship.playerMisses;
        ComputerHits = newship.ComputerHits;
        ComputerMisses = newship.ComputerMisses;
    }
}
